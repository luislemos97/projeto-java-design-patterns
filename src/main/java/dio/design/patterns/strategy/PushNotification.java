package dio.design.patterns.strategy;

public class PushNotification implements NotificationStrategy{
    @Override
    public void sendNotification(String message) {
        System.out.println("Sending push notification " + message);
    }
}
