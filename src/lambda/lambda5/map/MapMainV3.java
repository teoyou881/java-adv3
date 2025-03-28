package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//Let's eliminate redundancy by using a single method named `map()`
// instead of having both `mapStringToInteger()` and `mapStringToLength()` methods.
public class MapMainV3 {

  public static void main(String[] args) {
    List<String> list = List.of("1", "12", "123", "1234");

    List<Integer> numbers = map(list, s -> Integer.valueOf(s));
    System.out.println("numbers = " + numbers);

    List<Integer> lengths = map(list, s -> s.length());
    System.out.println("lengths = " + lengths);
  }

  public static List<Integer> map(List<String> list, Function<String, Integer> func) {
    List<Integer> numbers = new ArrayList<>();
    for (String s : list) {
      numbers.add(func.apply(s));
    }
    return numbers;
  }
}
