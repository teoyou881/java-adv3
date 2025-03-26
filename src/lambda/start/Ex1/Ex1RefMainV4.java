package lambda.start.Ex1;

import java.util.Random;
import lambda.Procedure;

public class Ex1RefMainV4 {

  public static void hello(Procedure procedure) {
    long startNs = System.nanoTime();

    procedure.run();

    long endNs = System.nanoTime();
    System.out.println("Execution time: " + (endNs - startNs) + " ns");
  }

  public static void main(String[] args) {
    hello(() -> {
      int randomValue = new Random().nextInt(6) + 1;
      System.out.println("Dice = " + randomValue);
    });
    hello(() -> {
      for (int i = 1; i <= 3; i++) {
        System.out.println("i = " + i);
      }
    });
  }
}
