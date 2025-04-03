package parallel.forkjoin;

import static util.MyLogger.log;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ForkJoinMain1 {

  public static void main(String[] args) {

    List<Integer> data = IntStream.rangeClosed(1, 8)
                                  .boxed()
                                  .toList();

    log("create list= " + data);

    long startTime = System.currentTimeMillis();
    ForkJoinPool pool = new ForkJoinPool(10);
    SumTask task = new SumTask(data);

    int result = pool.invoke(task);
    pool.close();

    long endTime = System.currentTimeMillis();
    log("time= " + (endTime - startTime) + "ms, sum= " + result);
    log("pool= " + pool);
  }

}
