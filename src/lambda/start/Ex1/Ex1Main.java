package lambda.start.Ex1;

import java.util.Random;

public class Ex1Main {

  public static void helloDice() {
    long startNs = System.nanoTime();

    // Start of code block
    int randomValue = new Random().nextInt(6) + 1;
    System.out.println("Dice roll = " + randomValue);
    // End of code block

    long endNs = System.nanoTime();
    System.out.println("Execution time: " + (endNs - startNs) + " ns");
  }

  public static void helloSum() {
    long startNs = System.nanoTime();

    // Start of code block
    for (int i = 1; i <= 3; i++) {
      System.out.println("i = " + i);
    }
    // End of code block

    long endNs = System.nanoTime();
    System.out.println("Execution time: " + (endNs - startNs) + " ns");
  }

  public static void main(String[] args) {
    helloDice();
    helloSum();
  }
}
