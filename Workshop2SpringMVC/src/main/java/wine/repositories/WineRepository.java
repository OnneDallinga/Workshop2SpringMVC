package wine.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import wine.domain.Wine;

@Repository
public interface WineRepository extends CrudRepository<Wine, Long> {

}
