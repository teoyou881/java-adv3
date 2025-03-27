package lambda.ex2.filter;


import java.util.ArrayList;
import java.util.List;

public class FilterExample {

  // Higher-order function: receives a predicate and filters the list
  public static List<Integer> filter(List<Integer> list, MyPredicate predicate) {
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

    List<Integer> negative = filter(numbers, (num) -> num < 0);
    List<Integer> positive = filter(numbers, (num) -> num > 0);
    List<Integer> even = filter(numbers, (num) -> num % 2 == 0);

    System.out.println("negative = " + negative);
    System.out.println("positive = " + positive);
    System.out.println("even = " + even);
  }

}