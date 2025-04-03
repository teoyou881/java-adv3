package parallel;

import static util.MyLogger.log;

public class ParallelMain2 {

  public static void main(String[] args) {

    long startTime = System.currentTimeMillis();

    // 1. Fork - divide the task into smaller sub-tasks.
    SumTask task1 = new SumTask(1, 5);
    SumTask task2 = new SumTask(6, 10);

    Thread thread1 = new Thread(task1, "thread-1");
    Thread thread2 = new Thread(task2, "thread-2");

// 2. Process the divided sub-tasks.
    thread1.start();
    thread2.start();

// 3. Join - combine the results from the sub-tasks.
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    int sum = task1.result + task2.result;

    long endTime = System.currentTimeMillis();
    System.out.println("execution time: " + (endTime - startTime) + "ms, sum: " + sum);

  }

  static class SumTask implements Runnable {

    int startValue;
    int endValue;
    int result = 0;

    public SumTask(int startValue, int endValue) {
      this.startValue = startValue;
      this.endValue = endValue;
    }

    @Override
    public void run() {
      log("start task");
      int sum = 0;
      for (int i = startValue; i <= endValue; i++) {
        int cal = HeavyJob.heavyTask(i);
        sum += cal;
      }
      result = sum;
      log("end task= " + result);
    }
  }
}
