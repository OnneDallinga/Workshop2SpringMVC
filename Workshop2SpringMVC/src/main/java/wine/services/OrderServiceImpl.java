package wine.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wine.domain.Order;
import wine.repositories.OrderRepository;

import java.util.Optional;

@Slf4j
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepo;

    public OrderServiceImpl(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order save(Order detachedOrder) {
        Order savedOrder = orderRepo.save(detachedOrder);
        log.debug("Saved order with id: " + savedOrder.getId());
        return savedOrder;
    }

    @Override
    @Transactional(readOnly = true)
    public Order findOrderById(Long id) {
        Optional<Order> orderOptional = orderRepo.findById(id);
        if(!orderOptional.isPresent()) {
            throw new RuntimeException("No product found with id: " + id);
        }
        return orderOptional.get();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Order> findAllOrdersByCustomerId(Long id) {
        return orderRepo.findAllByCustomerId(id);
    }

    @Override
    public void deleteById(Long idToDelete) {
        orderRepo.deleteById(idToDelete);
        log.debug("Deleted order with id: " + idToDelete);
    }
}
