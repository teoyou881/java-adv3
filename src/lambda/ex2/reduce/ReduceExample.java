package lambda.ex2.reduce;

import java.util.List;

public class ReduceExample {

  // Higher-order function: takes a function as an argument and reduces the list to a single value
  public static int reduce(List<Integer> list, int initial, MyReducer reducer) {

    // TODO: implement logic
    int result = initial;
    for (Integer num : list) {
      result = reducer.reduce(num, result);
    }
    return result;
  }

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4);
    System.out.println("List: " + numbers);

    // 1. Calculate sum (initial value 0, use addition logic)
    // TODO: implement
    int sum = reduce(numbers, 0, (a, b) -> {
      return a + b;
    });

    // 2. Calculate product (initial value 1, use multiplication logic)
    // TODO: implement
    int multi = reduce(numbers, 1, (a, b) -> {
      return a * b;
    });

    System.out.println("sum = " + sum);
    System.out.println("multi = " + multi);
  }
}