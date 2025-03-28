package lambda.lambda5.map;

import java.util.List;

//Let's eliminate redundancy by using a single method named `map()`
// instead of having both `mapStringToInteger()` and `mapStringToLength()` methods.
public class MapMainV5 {

  public static void main(String[] args) {
    List<String> fruits = List.of("apple", "banana", "mango");

    List<String> upperFruits = GenericMapper.map(fruits, s -> s.toUpperCase());
    System.out.println("upperFruits = " + upperFruits);

    List<Integer> lengthFruits = GenericMapper.map(upperFruits, s -> s.length());
    System.out.println("lengthFruits = " + lengthFruits);

    List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<String> startList = GenericMapper.map(integers, n -> "*".repeat(n));
    System.out.println("startList = " + startList);
  }

}
