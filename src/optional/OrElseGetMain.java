package optional;

import java.util.Optional;
import java.util.Random;

public class OrElseGetMain {

  public static void main(String[] args) {

    Optional<Integer> optValue = Optional.of(100);
    Optional<Integer> optEmpty = Optional.empty();

    System.out.println("simple calculation");
    Integer i1 = optValue.orElse(10 + 20); // Calculate 10 + 20 and discard the result
    Integer i2 = optEmpty.orElse(10 + 20);
    System.out.println("i1 = " + i1);
    System.out.println("i2 = " + i2);

    // orElse: if value is present, use it; otherwise use specified default
    System.out.println("=== orElse ===");
    System.out.println("When value is present");
    Integer value1 = optValue.orElse(createData());
    System.out.println("value1 = " + value1);

    System.out.println("When value is absent");
    Integer empty1 = optEmpty.orElse(createData());
    System.out.println("empty1 = " + empty1);

    // orElseGet: if value is present, use it; otherwise execute the lambda
    System.out.println("=== orElseGet ===");
    System.out.println("When value is present");
    Integer value2 = optValue.orElseGet(() -> createData());
    System.out.println("value2 = " + value2);

    System.out.println("When value is absent");
    Integer empty2 = optEmpty.orElseGet(OrElseGetMain::createData);
    System.out.println("empty2 = " + empty2);
  }

  public static int createData() {
    System.out.println("Creating data...");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    int createValue = new Random().nextInt(100);
    System.out.println("Data creation completed. Generated value: " + createValue);
    return createValue;
  }
}
