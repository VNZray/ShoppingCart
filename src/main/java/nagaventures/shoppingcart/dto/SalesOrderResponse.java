package nagaventures.shoppingcart.dto;

import java.time.LocalDateTime;
import java.util.List;

public class SalesOrderResponse {
    private Long customerId;
    private List<OrderDetails> orders;

    // Constructor, Getters, and Setters
    public SalesOrderResponse(Long customerId, List<OrderDetails> orders) {
        this.customerId = customerId;
        this.orders = orders;
    }

    public SalesOrderResponse() {
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<OrderDetails> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDetails> orders) {
        this.orders = orders;
    }

    public static class OrderDetails {
        private Long orderId;
        private String status;
        private LocalDateTime orderDate;
        private ProductDetail product;  // Change List<ProductDetail> to ProductDetail

        // Constructor, Getters, and Setters
        public OrderDetails(Long orderId, String status, LocalDateTime orderDate, ProductDetail product) {
            this.orderId = orderId;
            this.status = status;
            this.orderDate = orderDate;
            this.product = product;
        }

        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public LocalDateTime getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(LocalDateTime orderDate) {
            this.orderDate = orderDate;
        }

        public ProductDetail getProduct() {
            return product;
        }

        public void setProduct(ProductDetail product) {
            this.product = product;
        }
    }

    public static class ProductDetail {
        private Long productId;
        private String productName;
        private String model;
        private String capacity;
        private String variant;
        private String price;

        // Constructor, Getters, and Setters
        public ProductDetail() {
        }

        public ProductDetail(Long productId, String productName, String model, String capacity, String variant, String price) {
            this.productId = productId;
            this.productName = productName;
            this.model = model;
            this.capacity = capacity;
            this.variant = variant;
            this.price = price;
        }

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getCapacity() {
            return capacity;
        }

        public void setCapacity(String capacity) {
            this.capacity = capacity;
        }

        public String getVariant() {
            return variant;
        }

        public void setVariant(String variant) {
            this.variant = variant;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
