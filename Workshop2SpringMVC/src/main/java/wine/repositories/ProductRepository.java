package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.product.Product;
import wine.domain.product.Wine;

import java.util.Set;

public interface ProductRepository extends CrudRepository<Wine, Long> {

    Product findByName(String name);

    Set<Product> findAllOutOfStock();


}
