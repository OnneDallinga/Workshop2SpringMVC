package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.order.OrderLineItem;

public interface OrderLineItemRepository extends CrudRepository<OrderLineItem, Long> {
}
