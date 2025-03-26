package lambda.start.Ex1.my;

public class ForIter implements CalTime {

  @Override
  public void calculate() {
    for (int i = 1; i <= 3; i++) {
      System.out.println("i = " + i);
    }
  }
}
