package lambda.start.Ex1;

import java.util.Random;
import lambda.Procedure;

public class Ex1RefMainV2 {

  public static void hello(Procedure procedure) {
    long startNs = System.nanoTime();

    procedure.run();

    long endNs = System.nanoTime();
    System.out.println("Execution time: " + (endNs - startNs) + " ns");
  }

  public static void main(String[] args) {
    Procedure dice = new Procedure() {
      @Override
      public void run() {
        int randomValue = new Random().nextInt(6) + 1;
        System.out.println("Dice roll = " + randomValue);
      }
    };

    Procedure sum = new Procedure() {
      @Override
      public void run() {
        for (int i = 1; i <= 3; i++) {
          System.out.println("i = " + i);
        }
      }
    };
    hello(dice);
    hello(sum);
  }

  static class Dice implements Procedure {

    @Override
    public void run() {
      int randomValue = new Random().nextInt(6) + 1;
      System.out.println("Dice roll = " + randomValue);
    }
  }

  static class Sum implements Procedure {


    @Override
    public void run() {
      for (int i = 1; i <= 3; i++) {
        System.out.println("i = " + i);
      }
    }
  }
}
