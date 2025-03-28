package lambda.lambda5.filter;

import java.util.List;

public class FilterMainV4 {

  public static void main(String[] args) {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    List<Integer> evenResult = IntegerFilter.filter(numbers, x -> x % 2 == 0);
    List<Integer> oddResult = IntegerFilter.filter(numbers, x -> x % 2 == 1);

    System.out.println("evenResult = " + evenResult);
    System.out.println("oddResult = " + oddResult);

  }
}
