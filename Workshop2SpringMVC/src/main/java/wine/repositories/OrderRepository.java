package wine.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import wine.domain.Customer;
import wine.domain.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("FROM Order o JOIN o.customer c WHERE c.id=:customerId")
    public Iterable<Order> findAllByCustomerId(@Param("customerId") Long customerId);

}
