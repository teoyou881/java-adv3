package optional.logger;

public class LogMain2 {

  public static void main(String[] args) {
    Logger logger = new Logger();
    logger.setDebug(true);
    logger.debug(value100() + value200());

    System.out.println("=== turn off debug mode ===");
    logger.setDebug(false);
    logger.debug(value100() + value200());

    System.out.println("=== check debug mode ===");
    if (logger.isDebug()) {
      logger.debug(value100() + value200());
    }
  }

  static int value100() {
    System.out.println("call value100");
    return 100;
  }

  static int value200() {
    System.out.println("call value200");
    return 200;
  }
}