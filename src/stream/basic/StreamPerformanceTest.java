package stream.basic;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamPerformanceTest {

  public static void main(String[] args) {
    List<Integer> data = IntStream.rangeClosed(1, 10_000_000)
        .boxed()
        .collect(Collectors.toList());

    System.out.println("=== MyStreamV3 ===");
    long start1 = System.nanoTime();
    List<Integer> result1 = MyStreamV3.of(data)
        .filter(i -> i % 2 == 0)
        .map(i -> i * 10)
        .toList();
    long end1 = System.nanoTime();
    System.out.println("MyStreamV3 time: " + ((end1 - start1) / 1_000_000.0) + " ms");

    System.out.println("=== Java Stream ===");
    long start2 = System.nanoTime();
    List<Integer> result2 = data.stream()
        .filter(i -> i % 2 == 0)
        .map(i -> i * 10)
        .toList();
    long end2 = System.nanoTime();
    System.out.println("Java Stream time: " + ((end2 - start2) / 1_000_000.0) + " ms");
  }
}
