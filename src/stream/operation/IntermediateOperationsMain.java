package stream.operation;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationsMain {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

    // 1. filter - select even numbers only
    System.out.println("1. filter - select even numbers only");
    numbers.stream()
        .filter(n -> n % 2 == 0)
        .forEach(n -> System.out.print(n + " "));
    System.out.println("\n");

    // 2. map - square each number
    System.out.println("2. map - square each number");
    numbers.stream()
        .map(n -> n * n)
        .forEach(n -> System.out.print(n + " "));
    System.out.println("\n");

    // 3. distinct - remove duplicates
    System.out.println("3. distinct - remove duplicates");
    numbers.stream()
        .distinct()
        .forEach(n -> System.out.print(n + " "));
    System.out.println("\n");

    // 4. sorted - default sorting
    System.out.println("4. sorted - default sorting");
    Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
        .sorted()
        .forEach(n -> System.out.print(n + " "));
    System.out.println("\n");

    // 5. sorted with Comparator - descending order
    System.out.println("5. sorted with Comparator - descending order");
    Stream.of(3, 1, 4, 1, 5, 9, 2, 6, 5)
        .sorted(Comparator.reverseOrder())
        .forEach(n -> System.out.print(n + " "));
    System.out.println("\n");

    // 6. peek - for debugging
    System.out.println("6. peek - for debugging");
    numbers.stream()
        .peek(n -> System.out.print("before: " + n + ", "))
        .map(n -> n * n)
        .peek(n -> System.out.print("after: " + n + ", "))
        .limit(5)
        .forEach(n -> System.out.println("final value: " + n));
    System.out.println();

    // 7. limit - only the first 5 elements
    System.out.println("7. limit - only the first 5 elements");
    numbers.stream()
        .limit(5)
        .forEach(n -> System.out.print(n + " "));
    System.out.println("\n");

    // 8. skip - skip the first 5 elements
    System.out.println("8. skip - skip the first 5 elements");
    numbers.stream()
        .skip(5)
        .forEach(n -> System.out.print(n + " "));
    System.out.println("\n");

    List<Integer> numbers2 = List.of(1, 2, 3, 4, 5, 1, 2, 3);

    // 9. takeWhile - take elements while less than 5
    System.out.println("9. takeWhile - take elements while less than 5");
    numbers2.stream()
        .takeWhile(n -> n < 5)
        .forEach(n -> System.out.print(n + " "));
    System.out.println("\n");

    // 10. dropWhile - skip elements while less than 5
    System.out.println("10. dropWhile - skip elements while less than 5");
    numbers2.stream()
        .dropWhile(n -> n < 5)
        .forEach(n -> System.out.print(n + " "));
  }
}
