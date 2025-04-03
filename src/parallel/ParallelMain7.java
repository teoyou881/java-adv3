package parallel;

import static util.MyLogger.log;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class ParallelMain7 {

  public static void main(String[] args) throws InterruptedException {

    ExecutorService logicPool = Executors.newFixedThreadPool(400);
    int nThreads = 20; // 1, 2, 3, 10, 20

    for (int i = 1; i <= nThreads; i++) {
      String requestName = "request" + i;
      logicPool.submit(() -> {
        try {
          logic(requestName, logicPool);
        } catch (ExecutionException | InterruptedException e) {
          throw new RuntimeException(e);
        }
      });
      Thread.sleep(100); // Slight delay to observe thread order
    }

    logicPool.close();
  }

  private static void logic(String requestName, ExecutorService logicPool)
      throws ExecutionException, InterruptedException {
    log("[" + requestName + "] START");
    long startTime = System.currentTimeMillis();

    List<Future<Integer>> list = IntStream.rangeClosed(1, 4)
                                          .mapToObj(i -> logicPool.submit(
                                              () -> HeavyJob.heavyTask(i, requestName)))
                                          .toList();

    int sum = list.stream()
                  .mapToInt(f -> {
                    try {
                      return f.get();
                    } catch (InterruptedException | ExecutionException e) {
                      throw new RuntimeException(e);
                    }
                  })
                  .sum();

    long endTime = System.currentTimeMillis();
    log("[" + requestName + "] time: " + (endTime - startTime) + "ms, sum: " + sum);
  }
}
