package dio.design.patterns.service;

import dio.design.patterns.entity.Notification;
import dio.design.patterns.repository.NotificationRepository;
import dio.design.patterns.strategy.NotificationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationManager {
    private final NotificationRepository notificationRepository;
    private NotificationStrategy strategy;

    @Autowired
    public NotificationManager(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void setNotificationStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void notifyUser(String message) {
        if(strategy != null){
            strategy.sendNotification(message);
            Notification notification = new Notification();
            notification.setMessage(message);
            notificationRepository.save(notification);
        }
    }
}
