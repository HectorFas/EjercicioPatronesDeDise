package ProductFactory.NotificactionSystem;

abstract class Notification {
    String destination;

    public Notification(String destination) {
        this.destination = destination;
    }

    abstract void send();

    public static Notification to(String t) {
        if (t.startsWith("+")) {
            return new SMSNotificaction(t);
        } else if (t.contains("@")) {
            return new EmailNotification(t);
        } else if (t.startsWith("http")) {
            return new PushNotification(t);
        }
        throw new RuntimeException();
    }
}

class EmailNotification extends Notification {

    public EmailNotification(String destination) {
        super(destination);
    }

    @Override
    void send() {
        System.out.println("Enviando un email a: " + destination);
    }
}

class SMSNotificaction extends Notification {

    public SMSNotificaction(String destination) {
        super(destination);
    }
    @Override
    void send() {
        System.out.println("Enviando un SMS a: " + destination);
    }
}

class PushNotification extends Notification {

    public PushNotification(String destination) {
        super(destination);
    }

    @Override
    void send() {
        System.out.println("Enviando un push a: " + destination);
    }
}

public class Main {
    public static void main(String[] args) {

        Notification.to( "gerard@benigaslo.com").send();
        Notification.to("http://benigaslo.com/gerard").send();
        Notification.to("+34 678 789 890").send();
    }
}

