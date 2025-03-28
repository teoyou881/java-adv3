package lambda.lambda4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {

  public static void main(String[] args) {

    BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
    System.out.println("Sum = " + add.apply(1, 2));

    BiConsumer<String, Integer> repeat = (s, n) -> {
      for (int i = 0; i < n; i++) {
        System.out.println("s = " + s);
      }
      System.out.println();
    };
    repeat.accept("!", 100);

    BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;
    System.out.println("isGreater = " + isGreater.test(1, 2));
  }

}
