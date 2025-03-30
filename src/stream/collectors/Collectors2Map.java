package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {


  public static void main(String[] args) {
    //we use AtomicInteger not for thread safety, but to mutate a counter inside a lambda in a clean way.
    //In Java, variables used inside a lambda must be final or effectively final
    AtomicInteger ai = new AtomicInteger(1);
    Map<Integer, String> map1 = Stream.of("Apple", "Banana", "Tomato")
        .collect(Collectors.toMap(n -> ai.getAndIncrement(), name -> name));
    System.out.println("map1 = " + map1);

    // Duplicate key exception example:
    // java.lang.IllegalStateException: Duplicate key
    /*
    Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Banana")
        .collect(Collectors.toMap(
            name -> name,             // keyMapper
            name -> name.length()     // valueMapper
        ));
    System.out.println("map2 = " + map2);
    */
    Map<String, Integer> map2 = Stream.of("Apple", "Apple", "Banana").collect(Collectors.toMap(
        name -> name,             // keyMapper
        name -> name.length(),     // valueMapper
        (oldValue, newValue) -> oldValue + newValue // merge function on key conflict
    ));
    System.out.println("map2 = " + map2);

    // Specify Map type
    LinkedHashMap<String, Integer> map3 = Stream.of("Apple", "Apple", "Banana")
        .collect(Collectors.toMap(
            name -> name,
            String::length,
            (oldVal, newVal) -> oldVal + newVal,
            // merge function on key conflict
            LinkedHashMap::new
            // specify resulting map type
        ));
    System.out.println("map3 = " + map3.getClass());
  }
}
