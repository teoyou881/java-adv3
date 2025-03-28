package lambda.lambda5.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntPredicate;

//remove redundancy by using a single method named filter()
//instead of having both filterEvenNumber() and filterOddNumber().
public class FilterMainV3 {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    // Filter even numbers
    List<Integer> evenResult = filter(numbers, x -> x % 2 == 0);
    List<Integer> oddResult = filter(numbers, x -> x % 2 == 1);

    System.out.println("evenResult = " + evenResult);
    System.out.println("oddResult = " + oddResult);

  }

  private static List<Integer> filter(List<Integer> numbers, IntPredicate ip) {
    List<Integer> result = new ArrayList<>();
    for (Integer number : numbers) {
      if (ip.test(number)) {
        result.add(number);
      }
    }
    return result;

  }
}
