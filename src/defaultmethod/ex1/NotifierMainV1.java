package defaultmethod.ex1;

import java.util.List;

public class NotifierMainV1 {

  public static void main(String[] args) {
    List<Notifier> notifiers = List.of(
        new EmailNotifier(),
        new SMSNotifier(),
        new AppPushNotifier());

    // Notify each user with a welcome message
    notifiers.forEach(n -> n.notify("Welcome to the service!"));
  }
}
