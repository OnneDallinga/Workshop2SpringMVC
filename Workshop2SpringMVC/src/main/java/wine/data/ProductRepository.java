package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.product.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
