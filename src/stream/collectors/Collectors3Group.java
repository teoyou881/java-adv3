package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors3Group {

  public static void main(String[] args) {
    // Grouping by first alphabet character
    List<String> names = List.of("Apple", "Avocado", "Banana", "Blueberry", "Cherry");
    Map<String, List<String>> grouped = names.stream()
        .collect(Collectors.groupingBy(name -> name.substring(0, 1)));
    System.out.println("grouped = " + grouped);

    // Partitioning by whether the number is even
    Stream<Integer> integerStream = IntStream.rangeClosed(1, 6).boxed();
    Map<Boolean, List<Integer>> partitioned = integerStream.collect(Collectors.partitioningBy(n -> n
        % 2 == 0));
    System.out.println("partitioned = " + partitioned);

  }

}
