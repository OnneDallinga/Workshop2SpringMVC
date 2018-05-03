package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.order.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
