package lambda.ex1.test4;

import java.util.Arrays;
import lambda.Procedure;

public class M4MeasureTime {

  // Common utility method to measure execution time
  public static void measure(Procedure p) {
    long startNs = System.nanoTime();
    p.run(); // Execute logic (passed as lambda or anonymous class)
    long endNs = System.nanoTime();
    System.out.println("Execution time: " + (endNs - startNs) + " ns\n");
  }

  public static void main(String[] args) {
    // 1. Calculate the sum from 1 to N using a lambda
    measure(() -> {
      int N = 100;
      long sum = 0;
      for (int i = 1; i <= N; i++) {
        sum += i;
      }
      System.out.println("[Sum from 1 to " + N + "] Result: " + sum);
    });

    // 2. Sort an array using a lambda
    measure(() -> {
      int[] arr = {4, 3, 2, 1};
      System.out.println("Original array: " + Arrays.toString(arr));
      Arrays.sort(arr);
      System.out.println("[Sorted array] Result: " + Arrays.toString(arr));
    });
  }
}
