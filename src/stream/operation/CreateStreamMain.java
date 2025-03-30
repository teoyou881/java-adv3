package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamMain {

  public static void main(String[] args) {
    System.out.println("1. Create from Collection");
    List<String> list = List.of("a", "b", "c");
    Stream<String> stream1 = list.stream();
    stream1.forEach(System.out::println);

    System.out.println("2. Create from Array");
    String[] arr = {"a", "b", "c"};
    Stream<String> stream2 = Arrays.stream(arr);
    stream2.forEach(System.out::println);

    System.out.println("3. Create with Stream.of()");
    Stream<String> stream3 = Stream.of("a", "b", "c");
    stream3.forEach(System.out::println);

    System.out.println("4. Infinite Stream - iterate()");
    // iterate: takes an initial value and a function to generate the next value
    Stream<Integer> infiniteStream = Stream.iterate(0, n -> n + 2); // even numbers
    infiniteStream.limit(3).forEach(System.out::println);

    System.out.println("5. Infinite Stream - generate()");
    // generate: uses a Supplier to produce values indefinitely
    Stream<Double> randomStream = Stream.generate(Math::random);
    randomStream.limit(3).forEach(System.out::println);
  }
}
