package nagaventures.shoppingcart.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales_of_order")
public class SalesOfOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "order_id")
    private Long order_id;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "customer_id", nullable = false)
    private Long customer_id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    private ProductDimension product; // Relationship to ProductDimension

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    // Constructor
    public SalesOfOrder() {
    }

    // Getters and setters
    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public ProductDimension getProduct() {
        return product;
    }

    public void setProduct(ProductDimension product) {
        this.product = product;
    }
}
