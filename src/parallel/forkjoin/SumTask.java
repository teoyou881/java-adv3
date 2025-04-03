package parallel.forkjoin;

import static util.MyLogger.log;

import java.util.List;
import java.util.concurrent.RecursiveTask;
import parallel.HeavyJob;

public class SumTask extends RecursiveTask<Integer> {

  //  private static final int THRESHOLD = 4;
  private static final int THRESHOLD = 2;

  private final List<Integer> list;

  public SumTask(List<Integer> list) {
    this.list = list;
  }


  @Override
  protected Integer compute() {
    // directly sum if the working range is small
    if (list.size() <= THRESHOLD) {
      log("start task= " + list);
      int sum = list.stream()
                    .mapToInt(HeavyJob::heavyTask)
                    .sum();
      log("complete task= " + list + " -> sum= " + sum);
      return sum;
    }
    // if the scope of the task is large, split it int half to parallelize it.
    int middle = list.size() / 2;
    List<Integer> leftList = list.subList(0, middle);
    List<Integer> rightList = list.subList(middle, list.size());

    log("[conquer] " + list + " -> LEFT" + leftList + ", RIGHT" + rightList);

    SumTask leftTask = new SumTask(leftList);
    SumTask rightTask = new SumTask(rightList);

    // The left task is executed in a different thread
    leftTask.fork();
    // The right task is executed in the current thread
    int rightResult = rightTask.compute();
    // Wait for the left task to complete and get the result
    int leftResult = leftTask.join();
    // Combine the results from the left and right tasks
    int joinSum = leftResult + rightResult;
    log("LEFT[" + leftResult + "] + RIGHT[" + rightResult + "] -> sum: " + joinSum);
    return joinSum;


  }
}
