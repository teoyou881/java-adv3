package lambda.lambda5.map;

import java.util.List;

//Let's eliminate redundancy by using a single method named `map()`
// instead of having both `mapStringToInteger()` and `mapStringToLength()` methods.
public class MapMainV4 {

  public static void main(String[] args) {
    List<String> list = List.of("1", "12", "123", "1234");

    List<Integer> numbers = StringToIntegerMapper.map(list, s -> Integer.valueOf(s));
    System.out.println("numbers = " + numbers);

    List<Integer> lengths = StringToIntegerMapper.map(list, s -> s.length());
    System.out.println("lengths = " + lengths);
  }

}
