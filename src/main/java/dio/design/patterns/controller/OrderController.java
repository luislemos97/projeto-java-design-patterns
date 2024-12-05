package dio.design.patterns.controller;

import dio.design.patterns.entity.Order;
import dio.design.patterns.repository.OrderRepository;
import dio.design.patterns.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }

    @PostMapping
    public Order createOrder(@RequestParam String status){
        return orderService.createOrder(status);
    }


}
