package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.product.Wine;

public interface ProductRepository extends CrudRepository<Wine, Long> {
}
