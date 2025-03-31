package defaultmethod.ex2;

public class SMSNotifier implements Notifier {

  @Override
  public void notify(String message) {
    System.out.println("[SMS] " + message);
  }

//  @Override
//  public void scheduleNotification(String message, LocalDateTime scheduleTime) {
//    System.out.println("[SMS] " + message + " scheduled for " + scheduleTime);
//  }
}