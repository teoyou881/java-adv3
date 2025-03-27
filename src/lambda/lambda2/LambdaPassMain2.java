package lambda.lambda2;

import lambda.MyFunction;

public class LambdaPassMain2 {

  public static void main(String[] args) {
    MyFunction add = (a, b) -> a + b;
    MyFunction sub = (a, b) -> a - b;

    System.out.println("Passing lambda through variables:");
    calculate(add);
    calculate(sub);

    System.out.println("Passing lambda directly:");
    calculate((a, b) -> a + b);
    calculate((a, b) -> a - b);
  }

  static void calculate(MyFunction function) {
    int a = 1;
    int b = 2;
    System.out.println("Starting calculation...");
    int result = function.apply(a, b);
    System.out.println("Result: " + result);
  }
}
