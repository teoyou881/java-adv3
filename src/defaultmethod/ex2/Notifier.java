package defaultmethod.ex2;

import java.time.LocalDateTime;

public interface Notifier {

  void notify(String message);

  // add new method
  //void scheduleNotification(String message, LocalDateTime scheduleTime);

  // use default keyword
  default void scheduleNotification(String message, LocalDateTime scheduleTime) {
    System.out.println("[DEFAULT] " + message + " scheduled for " + scheduleTime);
  }
}
