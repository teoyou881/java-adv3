package lambda.ex1.test3;

import java.util.Arrays;
import lambda.Procedure;

public class Test {

  public static void measure(Procedure procedure) {

    long start = System.nanoTime();

    procedure.run();

    long end = System.nanoTime();
    System.out.println(end - start + "ms");
  }

  public static void main(String[] args) {
    Procedure sumP = () -> {
      int N = 100;
      long sum = 0;
      for (int i = 1; i <= N; i++) {
        sum += i;
      }
    };

    measure(sumP);
    measure(() -> {
      int[] arr = {4, 3, 2, 1};
      System.out.println("original array: " + Arrays.toString(arr));
      Arrays.sort(arr);
      System.out.println("sorted array: " + Arrays.toString(arr));
    });

  }

}
