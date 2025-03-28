package lambda.ex3;

import java.util.List;
import java.util.function.BiFunction;

public class ReduceExample {

  // Higher-order function: takes a function as an argument and reduces list elements into a single value
  public static int reduce(List<Integer> list, int initial,
      BiFunction<Integer, Integer, Integer> reducer) {
    int result = initial;
    for (int val : list) {
      result = reducer.apply(result, val);
    }
    return result;
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4);
    System.out.println("List: " + numbers);

    // 1. Calculate sum (initial value 0, addition logic)
    int sum = reduce(numbers, 0, (a, b) -> a + b);
    System.out.println("Sum (accumulated +): " + sum);

    // 2. Calculate product (initial value 1, multiplication logic using lambda)
    int product = reduce(numbers, 1, (a, b) -> a * b);
    System.out.println("Product (accumulated *): " + product);
  }
}
