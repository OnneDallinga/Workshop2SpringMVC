package wine.services;

import wine.domain.Order;

public interface OrderService {

    Order save(Order order);

    Order findOrderById(Long id);

    Iterable<Order> findAllOrders();

    Iterable<Order> findAllOrdersByCustomerId(Long id);

    void deleteById(Long id);

}
