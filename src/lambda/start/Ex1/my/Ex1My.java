package lambda.start.Ex1.my;

public class Ex1My {


  public static void main(String[] args) {

    long startNs = System.nanoTime();
    Dice dice = new Dice();
    dice.calculate();
    long endNs = System.nanoTime();
    System.out.println("Execution time: " + (endNs - startNs) + " ns");

    startNs = System.nanoTime();

    ForIter iter = new ForIter();
    iter.calculate();
    endNs = System.nanoTime();
    System.out.println("Execution time: " + (endNs - startNs) + " ns");
  }
}
