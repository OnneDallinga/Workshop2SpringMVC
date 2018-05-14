package wine.repositories;

import org.springframework.data.repository.CrudRepository;
import wine.domain.Product;
import wine.domain.Wine;

import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends CrudRepository<Product, Long> {

    Optional<Product> findByName(String name);

    Optional<Product> findById(Long id);

    //Set<Product> findAllOutOfStock();

}
