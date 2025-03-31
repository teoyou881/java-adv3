package defaultmethod.ex2;

import java.time.LocalDateTime;
import java.util.List;

public class NotifierMainV2 {

  public static void main(String[] args) {
    List<Notifier> notifiers = List.of(
        new EmailNotifier(),
        new SMSNotifier(),
        new AppPushNotifier());

    // Notify each user with a welcome message
    LocalDateTime plus1Days = LocalDateTime.now().plusDays(1);
    notifiers.forEach(n -> {
      n.scheduleNotification("hello!", plus1Days);
    });
  }
}
