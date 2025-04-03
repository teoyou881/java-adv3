package parallel;

import java.util.stream.IntStream;

public class ParallelMain1 {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    int sum = IntStream.rangeClosed(1, 10).map(HeavyJob::heavyTask).reduce(0, Integer::sum);

    long endTime = System.currentTimeMillis();
    System.out.println("execution time: " + (endTime - startTime) + "ms, sum: " + sum);

  }

}
