package stream.operation;

public class PerformanceTest {

  public static void main(String[] args) {
    long max = 100_000_000_0;

    // 1. Traditional for-loop
    long start1 = System.currentTimeMillis();
    long sum1 = 0;
    for (long i = 1; i <= max; i++) {
      sum1 += i;
    }
    long end1 = System.currentTimeMillis();
    System.out.println("1. For-loop sum = " + sum1 + ", time = " + (end1 - start1) + " ms");

    // 2. Stream (boxed type)
    long start2 = System.currentTimeMillis();
    long sum2 = java.util.stream.LongStream.rangeClosed(1, max)
        .boxed()
        .reduce(0L, Long::sum);
    long end2 = System.currentTimeMillis();
    System.out.println("2. Stream (boxed) sum = " + sum2 + ", time = " + (end2 - start2) + " ms");

    // 3. Primitive specialized LongStream
    long start3 = System.currentTimeMillis();
    long sum3 = java.util.stream.LongStream.rangeClosed(1, max)
        .sum();
    long end3 = System.currentTimeMillis();
    System.out.println("3. LongStream sum = " + sum3 + ", time = " + (end3 - start3) + " ms");
  }
}
