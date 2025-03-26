package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple3 {

  public static void main(String[] args) {
    // With explicit parameter types
    MyFunction function1 = (int a, int b) -> a + b;

    // Parameter types can be omitted — inferred from the functional interface
    MyFunction function2 = (a, b) -> a + b;

    int result = function2.apply(1, 2);
    System.out.println("result = " + result);
  }
}
