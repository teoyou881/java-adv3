package stream.collectors;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4MinMax {

  public static void main(String[] args) {
    // Useful in downstream collectors
    Integer max1 = Stream.of(1, 2, 3)
        .collect(Collectors.maxBy(
            (i1, i2) -> i1.compareTo(i2)))
        .get();
    System.out.println("max1 = " + max1);

    //method ref
    /*Integer max = Stream.of(1, 2, 3)
        .collect(Collectors.maxBy(Integer::compareTo))
        .get();*/

    // Directly using max() on stream
    Integer max2 = Stream.of(1, 2, 3)
        .max((i1, i2) -> i1.compareTo(i2))
        .get();
    System.out.println("max2 = " + max2);

    // Using method reference
    Integer max3 = Stream.of(1, 2, 3)
        .max(Integer::compareTo)
        .get();
    System.out.println("max3 = " + max3);

    // Using primitive specialized stream
    int max4 = IntStream.of(1, 2, 3)
        .max()
        .getAsInt();
    System.out.println("max4 = " + max4);
  }
}
