package stream.basic;

import java.util.List;
import java.util.stream.Stream;

//One-time use (Single consumption)
public class DuplicateExecutionMain {

  public static void main(String[] args) {
    // Check for duplicate stream execution
    Stream<Integer> stream = Stream.of(1, 2, 3);

    stream.forEach(System.out::println); // 1. First execution

    // Error message: java.lang.IllegalStateException: stream has already been operated upon or closed
    // stream.forEach(System.out::println); // 2. Cannot reuse the same stream, uncommenting this line will cause an exception

    // Alternative: create a new stream from the source list
    List<Integer> list = List.of(1, 2, 3);
    Stream.of(list).forEach(System.out::println);
    Stream.of(list).forEach(System.out::println);
  }
}
