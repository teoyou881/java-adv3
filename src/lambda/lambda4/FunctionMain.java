package lambda.lambda4;

import java.util.function.Function;

public class FunctionMain {

  public static void main(String[] args) {

    //anonymous
    Function<String, Integer> function1 = new Function<String, Integer>() {
      @Override
      public Integer apply(String string) {
        return string.length();
      }
    };
    System.out.println("function1 = " + function1.apply("hello"));

    //lambda
    Function<String, Integer> function2 = (string) -> string.length();
    System.out.println("function2 = " + function2.apply("hello"));
  }


}
