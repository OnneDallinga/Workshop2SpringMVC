package wine.data;

import org.springframework.data.repository.CrudRepository;
import wine.domain.customer.Customer;
import wine.domain.order.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllOrdersOfCustomer(Customer customer);

    List<Order>findAllPendingOrders();

    List<Order>findAllCompletedOrders();

}
