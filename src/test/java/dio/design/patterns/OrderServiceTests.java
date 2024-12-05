package dio.design.patterns;

import static org.assertj.core.api.Assertions.assertThat;

import dio.design.patterns.entity.Order;
import dio.design.patterns.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderServiceTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void testOrderCreation() {
        Order order = orderService.createOrder("Order received");
        assertThat(order.getId()).isNotNull();
    }
}
