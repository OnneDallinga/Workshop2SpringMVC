package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.order.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
