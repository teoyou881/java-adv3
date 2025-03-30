package optional.logger;

import java.util.function.Supplier;

public class Logger {

  private boolean isDebug = false;

  public boolean isDebug() {
    return isDebug;
  }

  public void setDebug(boolean debug) {
    isDebug = debug;
  }

  // Prints the message only if DEBUG mode is enabled – directly takes data
  public void debug(Object message) {
    if (isDebug) {
      System.out.println("[DEBUG] " + message);
    }
  }

  //add
  // Prints only if DEBUG is enabled – takes and executes a lambda
  public void debug(Supplier<?> supplier) {
    if (isDebug) {
      System.out.println("[DEBUG] " + supplier.get());
    }
  }
}
