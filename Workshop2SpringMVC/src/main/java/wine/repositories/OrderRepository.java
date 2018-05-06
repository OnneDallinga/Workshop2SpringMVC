package wine.repositories;

import org.springframework.data.repository.CrudRepository;
import wine.domain.Customer;
import wine.domain.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAllOrdersOfCustomer(Customer customer);

    List<Order> findShippedOrdersOnly();

    List<Order> findShipmentPendingOrdersOnly();

    List<Order> findAllCompletedOrders();

}
