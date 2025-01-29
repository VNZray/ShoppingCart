package nagaventures.shoppingcart.controller;

import org.springframework.web.bind.annotation.*;

import nagaventures.shoppingcart.model.ProductDimension;
import nagaventures.shoppingcart.repository.ProductDimensionRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductDimensionController {

    private final ProductDimensionRepository productDimensionRepository;

    public ProductDimensionController(ProductDimensionRepository productDimensionRepository) {
        this.productDimensionRepository = productDimensionRepository;
    }

    // Get all products
    @GetMapping
    public List<ProductDimension> getAllProducts() {
        return productDimensionRepository.findAll();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDimension> getProductById(@PathVariable Long id) {
        Optional<ProductDimension> product = productDimensionRepository.findById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add new product
    @PostMapping
    public ProductDimension addProduct(@RequestBody ProductDimension product) {
        return productDimensionRepository.save(product);
    }

    // Update product by ID
    @PutMapping("/{id}")
    public ResponseEntity<ProductDimension> updateProduct(@PathVariable Long id, @RequestBody ProductDimension productDetails) {
        return productDimensionRepository.findById(id).map(product -> {
            product.setProduct_name(productDetails.getProduct_name());
            product.setModel(productDetails.getModel());
            product.setCapacity(productDetails.getCapacity());
            product.setVariant(productDetails.getVariant());
            product.setPrice(productDetails.getPrice());
            return ResponseEntity.ok(productDimensionRepository.save(product));
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}

