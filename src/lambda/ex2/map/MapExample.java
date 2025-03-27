package lambda.ex2.map;

import java.util.ArrayList;
import java.util.List;

public class MapExample {

  // Higher-order function: takes a function and applies it to each element in the list
  public static List<String> map(List<String> list, StringFunction func) {
    List<String> result = new ArrayList<>();
    for (String s : list) {
      result.add(func.apply(s));
    }
    return result;
  }

  public static void main(String[] args) {
    List<String> words = List.of("hello", "java", "lambda");
    System.out.println("Original list: " + words);

    // 1. Convert to uppercase
    // TODO: implement
    List<String> upper = map(words, (word) -> {
      return word.toUpperCase();
    });

    // 2. Add *** to front and back (use lambda)
    // TODO: implement
    List<String> addSomething = map(words, (word) -> {
      return "***" + word + "***";
    });

    System.out.println("upper = " + upper);
    System.out.println("addSomething = " + addSomething);

  }
}