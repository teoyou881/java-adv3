package parallel;

import static util.MyLogger.log;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParallelMain3 {

  public static void main(String[] args) throws InterruptedException, ExecutionException {
    // Prepare the thread pool
    ExecutorService es = Executors.newFixedThreadPool(2);
    long startTime = System.currentTimeMillis();

    // 1. Divide the task
    SumTask task1 = new SumTask(1, 4);
    SumTask task2 = new SumTask(5, 8);

    // 2. Process each sub-task
    Future<Integer> future1 = es.submit(task1);
    Future<Integer> future2 = es.submit(task2);

    // 3. Join - wait for and combine results
    Integer result1 = future1.get();
    Integer result2 = future2.get();
    int sum = result1 + result2;

    long endTime = System.currentTimeMillis();
    log("time: " + (endTime - startTime) + "ms, sum: " + sum);

    es.close(); // This should be es.shutdown()
  }

  static class SumTask implements Callable<Integer> {

    int startValue;
    int endValue;

    public SumTask(int startValue, int endValue) {
      this.startValue = startValue;
      this.endValue = endValue;
    }

    @Override
    public Integer call() {
      log("Task started");
      int sum = 0;
      for (int i = startValue; i <= endValue; i++) {
        int calculated = HeavyJob.heavyTask(i);
        sum += calculated;
      }
      log("Task completed result=" + sum);
      return sum;
    }
  }
}
