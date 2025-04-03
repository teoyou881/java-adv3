package parallel;

import static util.MyLogger.log;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelMain6 {

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

    Future<Integer> f1 = logicPool.submit(() -> HeavyJob.heavyTask(1, requestName));
    Future<Integer> f2 = logicPool.submit(() -> HeavyJob.heavyTask(2, requestName));
    Future<Integer> f3 = logicPool.submit(() -> HeavyJob.heavyTask(3, requestName));
    Future<Integer> f4 = logicPool.submit(() -> HeavyJob.heavyTask(4, requestName));

    int sum;
    Integer i1 = f1.get();
    Integer i2 = f2.get();
    Integer i3 = f3.get();
    Integer i4 = f4.get();
    sum = i1 + i2 + i3 + i4;

    long endTime = System.currentTimeMillis();
    log("[" + requestName + "] time: " + (endTime - startTime) + "ms, sum: " + sum);
  }
}
