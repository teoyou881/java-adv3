package parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelMain4 {

  public static void main(String[] args) {
    int processorCount = Runtime.getRuntime()
                                .availableProcessors();
    ForkJoinPool commonPool = ForkJoinPool.commonPool();

    long startTime = System.currentTimeMillis();

    int sum = IntStream.rangeClosed(1, 30)
                       .parallel()
                       .map(HeavyJob::heavyTask)
                       .reduce(0, Integer::sum);

    long endTime = System.currentTimeMillis();
    System.out.println("execution time: " + (endTime - startTime) + "ms, sum: " + sum);

  }

}
