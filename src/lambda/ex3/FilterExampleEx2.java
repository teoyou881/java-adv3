package lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

public class FilterExampleEx2 {

  public static List<Integer> filter(List<Integer> list, IntPredicate predicate) {
    List<Integer> result = new ArrayList<>();
    for (int val : list) {
      if (predicate.test(val)) {
        result.add(val);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);
    System.out.println("Original list: " + numbers);

    // 1. Extract only negative numbers
    List<Integer> negatives = filter(numbers, (x) -> x < 0);
    System.out.println("Negatives only: " + negatives);

    // 2. Extract only even numbers
    List<Integer> evens = filter(numbers, value -> value % 2 == 0);
    System.out.println("Evens only: " + evens);
  }
}
