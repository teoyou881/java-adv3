package lambda.start.Ex1.my;

import java.util.Random;

public class Dice implements CalTime {

  @Override
  public void calculate() {
    int randomValue = new Random().nextInt(6) + 1;
    System.out.println("Dice roll = " + randomValue);
  }
}
