package parallel;

import static util.MyLogger.log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ParallelMain5 {

  public static void main(String[] args) throws InterruptedException {
    // Limit the parallelism level to 3
    System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "3");

    // Add request pool
    ExecutorService requestPool = Executors.newFixedThreadPool(100);
    int nThreads = 20; // 1, 2, 3, 10, 20

    for (int i = 1; i <= nThreads; i++) {
      String requestName = "request" + i;
      requestPool.submit(() -> logic(requestName));
      Thread.sleep(100); // Slight delay to observe thread order
    }

    requestPool.close();
  }

  private static void logic(String requestName) {
    log("[" + requestName + "] START");
    long startTime = System.currentTimeMillis();

    int sum = IntStream.rangeClosed(1, 4)
                       .parallel() // Removing this may improve performance
                       .map(i -> HeavyJob.heavyTask(i, requestName))
                       .reduce(0, Integer::sum);

    long endTime = System.currentTimeMillis();
    log("[" + requestName + "] time: " + (endTime - startTime) + "ms, sum: " + sum);
  }
}
