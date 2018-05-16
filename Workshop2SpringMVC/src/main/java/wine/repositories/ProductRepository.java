package wine.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wine.domain.Product;
import wine.domain.Wine;

import java.util.Optional;
import java.util.Set;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query("SELECT ALL FROM Product p WHERE p.stockQuantity = '0'")
    public Iterable<Product> findAllProductsOutOfStock();

}
