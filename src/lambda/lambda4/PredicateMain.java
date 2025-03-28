package lambda.lambda4;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateMain {

  public static void main(String[] args) {
    Predicate<Integer> predicate = new Predicate<Integer>() {
      @Override
      public boolean test(Integer integer) {
        return integer % 2 == 0;
      }
    };
    System.out.println("predicate = " + predicate.test(5));

    Function<Integer, Boolean> function = integer -> integer % 2 == 0;
    System.out.println("function = " + function.apply(5));
  }

}
