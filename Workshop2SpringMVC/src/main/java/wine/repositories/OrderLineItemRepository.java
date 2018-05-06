package wine.repositories;

import org.springframework.data.repository.CrudRepository;
import wine.domain.OrderLineItem;

public interface OrderLineItemRepository extends CrudRepository<OrderLineItem, Long> {
}
