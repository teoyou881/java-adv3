package stream.operation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperationsMain {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10);

    // 1. collect - collect into a List
    System.out.println("1. collect - collect into a List");
    List<Integer> evenNumbers1 = numbers.stream()
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
    System.out.println("Even number list: " + evenNumbers1);
    System.out.println();

    // 2. toList() (Java 16+)
    System.out.println("2. toList() (Java 16+)");
    List<Integer> evenNumbers2 = numbers.stream()
        .filter(n -> n % 2 == 0)
        .toList(); // unmodifiable list
    System.out.println("Even number list: " + evenNumbers2);
    System.out.println();

    // 3. toArray - convert to array
    System.out.println("3. toArray - convert to array");
    Integer[] arr = numbers.stream()
        .filter(n -> n % 2 == 0)
        .toArray(Integer[]::new);
    System.out.println("Even number array: " + Arrays.toString(arr));
    System.out.println();

    // 4. forEach - process each element
    System.out.println("4. forEach - process each element");
    numbers.stream()
        .limit(5)
        .forEach(n -> System.out.print(n + " "));
    System.out.println("\n");

    // 5. count - count elements
    System.out.println("5. count - count elements");
    long count = numbers.stream()
        .filter(n -> n > 5)
        .count();
    System.out.println("Count of numbers > 5: " + count);
    System.out.println();

    // 6. reduce - sum of elements
    System.out.println("6. reduce - sum of elements");
    System.out.println("reduce without identity value");
    Optional<Integer> sum1 = numbers.stream()
        .reduce((a, b) -> a + b);
    System.out.println("Sum (no identity): " + sum1.get());

    System.out.println("reduce with identity value");
    int sum2 = numbers.stream()
        .reduce(100, (a, b) -> a + b);
    System.out.println("Sum (identity 100): " + sum2);
    System.out.println();

    // 7. min - find minimum
    System.out.println("7. min - find minimum");
    Optional<Integer> min = numbers.stream()
//        .min((a, b) -> a < b ? a : b);
        .min(Integer::compareTo);
    System.out.println("Minimum: " + min.get());
    System.out.println();

    // 8. max - find maximum
    System.out.println("8. max - find maximum");
    Optional<Integer> max = numbers.stream()
        .max(Integer::compareTo);
    System.out.println("Maximum: " + max.get());
    System.out.println();

    // 9. findFirst - find first element
    System.out.println("9. findFirst - find first element");
    Integer first = numbers.stream()
        .filter(n -> n > 5)
        .findFirst().get();
    System.out.println("First number > 5: " + first);
    System.out.println();

    // 10. findAny - find any element
    System.out.println("10. findAny - find any element");
    Integer any = numbers.stream()
        .filter(n -> n > 5)
        .findAny().get();
    System.out.println("Any number > 5: " + any);
    System.out.println();

    // 11. anyMatch - check if any match condition
    System.out.println("11. anyMatch - check if any match condition");
    boolean hasEven = numbers.stream()
        .anyMatch(n -> n % 2 == 0);
    System.out.println("Is there any even number? " + hasEven);
    System.out.println();

    // 12. allMatch - check if all match condition
    System.out.println("12. allMatch - check if all match condition");
    boolean allPositive = numbers.stream()
        .allMatch(n -> n > 0);
    System.out.println("Are all numbers positive? " + allPositive);
    System.out.println();

    // 13. noneMatch - check if none match condition
    System.out.println("13. noneMatch - check if none match condition");
    boolean noNegative = numbers.stream()
        .noneMatch(n -> n < 0);
    System.out.println("Are there no negative numbers? " + noNegative);
  }
}
