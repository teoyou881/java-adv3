package stream.operation;

import java.util.IntSummaryStatistics;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {

  public static void main(String[] args) {
    // Creating primitive specialized streams (IntStream, LongStream, DoubleStream)
    IntStream stream = IntStream.of(1, 2, 3, 4, 5);
    stream.forEach(i -> System.out.print(i + " "));
    System.out.println();

    // Range creation methods (available for IntStream and LongStream)
    IntStream range1 = IntStream.range(1, 6);
    IntStream range2 = IntStream.rangeClosed(1, 6);
    System.out.println("range1 = " + range1);
    System.out.println("range2 = " + range2);

    /* statistics-related methods (sum, average, max, min, count)
     * */

    //average()
    double avgDouble = IntStream.rangeClosed(1, 6).average().getAsDouble();
    System.out.println("avgDouble = " + avgDouble);

    //sum()
    int sum = IntStream.rangeClosed(1, 6).sum();
    System.out.println("sum = " + sum);

    //summaryStatistics(): gets full statistically summary
    IntSummaryStatistics stats = IntStream.rangeClosed(1, 10).summaryStatistics();
//    Method[] declaredMethods = stats.getClass().getDeclaredMethods();
//    for (Method declaredMethod : declaredMethods) {
//      System.out.println("declaredMethod = " + declaredMethod);
//    }
    System.out.println("sum: " + stats.getSum());
    System.out.println("average: " + stats.getAverage());
    System.out.println("max: " + stats.getMax());
    System.out.println("min: " + stats.getMin());
    System.out.println("count: " + stats.getCount());

    /*type conversion methods
     * */

    // IntStream -> LongStream
    LongStream longStream = IntStream.range(1, 5).asLongStream();

    // IntStream -> DoubleStream
    DoubleStream doubleStream = IntStream.range(1, 5).asDoubleStream();

    // IntStream -> Stream<Integer>
    Stream<Integer> boxedStream = IntStream.range(1, 5).boxed();

    /*3. Primitive specialized mapping
     * */

    // int -> long mapping
    LongStream mappedLong = IntStream.range(1, 5).mapToLong(i -> i * 10L);

    // int -> double mapping
    DoubleStream mappedDouble = IntStream.range(1, 5).mapToDouble(i -> i * 1.5);

    // int -> object mapping
    Stream<String> mappedObj = IntStream.range(1, 5).mapToObj(i -> "Number: " + i);

    // 4. Object stream -> primitive specialized stream
    Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    IntStream intStream = integerStream.mapToInt(i -> i);

    // 5. Using object stream -> primitive specialized stream for sum
    int result = Stream.of(1, 2, 3, 4, 5).mapToInt(i -> i).sum();
    System.out.println("result = " + result);
  }
}


