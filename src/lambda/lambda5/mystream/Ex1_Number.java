package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

public class Ex1_Number {

  public static void main(String[] args) {
    // Keep only even numbers, then return each value multiplied by 2
    List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> directResult = direct(numbers);
    System.out.println("directResult = " + directResult);

    List<Integer> lambdaResult = lambda(numbers);
    System.out.println("lambdaResult = " + lambdaResult);
  }

  static List<Integer> direct(List<Integer> numbers) {
    // TODO implement logic
    List<Integer> result = new ArrayList<>();
    for (Integer i : numbers) {
      if (i % 2 == 0) {
        result.add(i * 2);
      }
    }
    return result;
  }

  static List<Integer> lambda(List<Integer> numbers) {
    // TODO implement logic
    return GenericMapper.map(GenericFilter.filter(numbers, i -> i % 2 == 0), n -> n * 2);
  }
}