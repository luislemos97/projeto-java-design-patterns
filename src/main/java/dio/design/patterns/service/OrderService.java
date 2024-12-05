package dio.design.patterns.service;

import dio.design.patterns.entity.Order;
import dio.design.patterns.repository.OrderRepository;
import dio.design.patterns.strategy.EmailNotification;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private NotificationManager notificationManager;

    @Transactional
    public Order createOrder(String status){
        Order order = new Order();
        order.setStatus(status);
        orderRepository.save(order);
        notificationManager.setNotificationStrategy(new EmailNotification());
        notificationManager.notifyUser("New order created with status: " + status);

        return order;
    }


}
