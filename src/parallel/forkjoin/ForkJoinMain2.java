package parallel.forkjoin;

import static util.MyLogger.log;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;

public class ForkJoinMain2 {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    int processorCount = Runtime.getRuntime()
                                .availableProcessors();
    ForkJoinPool commonPool = ForkJoinPool.commonPool();
    log("processorCount = " + processorCount + ", commonPool = " + commonPool.getParallelism());

    List<Integer> data = IntStream.rangeClosed(1, 8)
                                  .boxed()
                                  .toList();
    log("[Generated] " + data);

    SumTask task = new SumTask(data);
//    Integer result = task.invoke(); // Uses the common pool
//    log("Final result: " + result);

    ForkJoinTask<Integer> fork = task.fork();
//    Integer i = fork.get();
  }
}
