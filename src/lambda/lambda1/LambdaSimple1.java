package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple1 {

  public static void main(String[] args) {

    //basic
    //If the body of a lambda expression uses curly braces {},
    //the return keyword must be explicitly included when a return value is expected
    //even if it's just a single line.
    MyFunction function1 = (int a, int b) -> {
      return a + b;
    };
    System.out.println("function1 = " + function1.apply(1, 2));

    //Braces and returns can be omitted for single expressions
    MyFunction function2 = (int a, int b) -> a + b;


  }

}
