package wine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import wine.domain.Order;
import wine.services.OrderService;

@Controller
public class OrderController implements ControllerInterface {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders/all")
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAllOrders());
        return "orders/orders";
    }

    @GetMapping("/orders/{id}/show")
    public String showOrderById(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.findOrderById(id));
        return "orders/show";
    }

    @GetMapping("/orders/new")
    public String newOrder(@ModelAttribute Order order) {
        return "orders/orderform";
    }

    @GetMapping("orders/{id}/edit")
    public String updateOrder(@PathVariable Long id, Model model) {
        model.addAttribute("order", orderService.findOrderById(id));
        return "order/orderform";
    }

    @PostMapping("order")
    public String saveWine(@ModelAttribute Order order) {
        orderService.save(order);
        return "redirect:/orders/" + order.getId() + "/show";
    }

    @GetMapping("/orders/{id}/delete")
    public String deleteOrderById(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/orders/all";
    }

}
