package dio.design.patterns.strategy;

import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending email " + message);
    }
}
