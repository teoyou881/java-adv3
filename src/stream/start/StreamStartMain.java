package stream.start;

import java.util.List;

public class StreamStartMain {

  public static void main(String[] args) {
    List<String> names = List.of("Apple", "Banana", "Cherry", "Mango", "Orange");

    // Filter names that start with "B" and convert to uppercase
    List<String> result = names.stream()
        .filter(s -> s.startsWith("B"))
        .map(String::toUpperCase)
        .toList();
    System.out.println("result = " + result);

    // External iteration using for-each loop
    System.out.println("========== External Iteration ==========");
    for (String s : result) {
      System.out.println("s = " + s);
    }

    // Internal iteration using forEach
    System.out.println("========== Internal Iteration with forEach ==========");
    names.stream()
        .filter(s -> s.startsWith("B"))
        .map(String::toUpperCase)
        .forEach(System.out::println);
  }

}
