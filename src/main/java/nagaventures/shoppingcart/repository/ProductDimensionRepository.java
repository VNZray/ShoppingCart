package nagaventures.shoppingcart.repository;

import nagaventures.shoppingcart.model.ProductDimension;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDimensionRepository extends JpaRepository<ProductDimension, Long> {

}