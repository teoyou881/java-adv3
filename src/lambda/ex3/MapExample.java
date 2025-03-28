package lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class MapExample {

  public static List<String> map(List<String> list, UnaryOperator<String> func) {
    List<String> result = new ArrayList<>();
    for (String str : list) {
      result.add(func.apply(str));
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> words = List.of("hello", "java", "lambda");
    System.out.println("Original list: " + words);

    // 1. Convert to uppercase
    List<String> upperList = map(words, s -> s.toUpperCase());
    System.out.println("Uppercase result: " + upperList);

    // 2. Add *** before and after each word (using lambda)
    List<String> decoratedList = map(words, s -> "***" + s + "***");
    System.out.println("Decorated result: " + decoratedList);
  }
}
