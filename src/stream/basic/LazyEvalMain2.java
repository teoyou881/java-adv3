package stream.basic;

import java.util.List;
import lambda.lambda5.mystream.MyStreamV3;

//Pipeline structure
//A stream forms a pipeline where intermediate operations (like map, filter, etc.) are chained together.
//These operations are executed only when a terminal operation (like forEach, collect, reduce, etc.) is invoked.

//Lazy operations
//Intermediate operations are not executed immediately.
//They are deferred and processed all at once when the terminal operation is executed.
public class LazyEvalMain2 {

  public static void main(String[] args) {
    List<Integer> data = List.of(1, 2, 3, 4, 5, 6);
    ex1(data);
    ex2(data);
  }

  //even though there is no terminal operation, code was executed immediately
  private static void ex1(List<Integer> data) {
    System.out.println("== MyStreamV3 Start ==");
    MyStreamV3.of(data)
        .filter(i -> {
          boolean isEven = i % 2 == 0;
          System.out.println("filter() called: " + i + " (" + isEven + ")");
          return isEven;
        })
        .map(i -> {
          int mapped = i * 10;
          System.out.println("map() called: " + i + " -> " + mapped);
          return mapped;
        });

//    System.out.println("result = " + result);
    System.out.println("== MyStreamV3 End ==");
  }

  private static void ex2(List<Integer> data) {
    System.out.println("== Stream API Start ==");
    data.stream()
        .filter(i -> {
          boolean isEven = i % 2 == 0;
          System.out.println("filter() called: " + i + " (" + isEven + ")");
          return isEven;
        })
        .map(i -> {
          int mapped = i * 10;
          System.out.println("map() called: " + i + " -> " + mapped);
          return mapped;
        });

//    System.out.println("result = " + result);
    System.out.println("== Stream API End ==");
  }
}