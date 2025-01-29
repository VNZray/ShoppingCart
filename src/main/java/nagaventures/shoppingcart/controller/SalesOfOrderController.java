package nagaventures.shoppingcart.controller;

import nagaventures.shoppingcart.dto.SalesOrderResponse;
import nagaventures.shoppingcart.model.ProductDimension;
import nagaventures.shoppingcart.model.SalesOfOrder;
import nagaventures.shoppingcart.repository.ProductDimensionRepository;
import nagaventures.shoppingcart.repository.SalesOfOrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class SalesOfOrderController {

    private final SalesOfOrderRepository salesOfOrderRepository;
    private final ProductDimensionRepository productDimensionRepository;

    public SalesOfOrderController(SalesOfOrderRepository salesOfOrderRepository, ProductDimensionRepository productDimensionRepository) {
        this.salesOfOrderRepository = salesOfOrderRepository;
        this.productDimensionRepository = productDimensionRepository;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<SalesOrderResponse>> getAllOrdersWithProducts() {
        List<SalesOrderResponse> ordersWithProducts = salesOfOrderRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(SalesOfOrder::getCustomer_id)) // Group by customerId
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getKey)) // Sort by customerId
                .map(entry -> {
                    Long customerId = entry.getKey();
                    List<SalesOfOrder> orders = entry.getValue();

                    // Mapping orders for a particular customer
                    List<SalesOrderResponse.OrderDetails> orderDetailsList = orders.stream()
                            .map(order -> {
                                // Mapping each order to a response object
                                return new SalesOrderResponse.OrderDetails(
                                        order.getOrder_id(),
                                        order.getStatus(),
                                        order.getOrderDate(),
                                        new SalesOrderResponse.ProductDetail(
                                                order.getProduct().getProduct_id(),
                                                order.getProduct().getProduct_name(),
                                                order.getProduct().getModel(),
                                                order.getProduct().getCapacity(),
                                                order.getProduct().getVariant(),
                                                order.getProduct().getPrice().toString()
                                        )
                                );
                            })
                            .collect(Collectors.toList());

                    // Creating the response object for a customer
                    SalesOrderResponse response = new SalesOrderResponse();
                    response.setCustomerId(customerId);
                    response.setOrders(orderDetailsList);

                    return response;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(ordersWithProducts);
    }



    // Purchase Item
    @PostMapping("/purchase/{customer_id}/{id}")
    public ResponseEntity<SalesOfOrder> purchaseItem(@PathVariable Long customer_id, @PathVariable Long id) {
        // Find the product by ID
        Optional<ProductDimension> productOpt = productDimensionRepository.findById(id);

        if (productOpt.isEmpty()) {
            // Return 404 if product is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        ProductDimension product = productOpt.get();

        // Create a new order
        SalesOfOrder newOrder = new SalesOfOrder();
        newOrder.setProduct(product);
        newOrder.setCustomer_id(customer_id);
        newOrder.setStatus("Pending"); // Default status
        newOrder.setOrderDate(LocalDateTime.now()); // Set current date

        try {
            // Save the order
            SalesOfOrder savedOrder = salesOfOrderRepository.save(newOrder);

            // Return 201 Created when the order is successfully saved
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);

        } catch (Exception e) {
            // Return 500 Internal Server Error if something goes wrong with the order
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
