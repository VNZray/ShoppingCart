package nagaventures.shoppingcart.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_dimension")
public class ProductDimension {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment primary key
    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "product_name", nullable = false, length = 20)
    private String product_name;

    @Column(name = "model", nullable = false,  length = 10)
    private String model;

    @Column(name = "capacity", nullable = false,  length = 10)
    private String capacity;

    @Column(name = "variant", nullable = false,  length = 10)
    private String variant;

    @Column(name = "price", nullable = false,  length = 10)
    private String price;

    // Constructor
    public ProductDimension() {
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}