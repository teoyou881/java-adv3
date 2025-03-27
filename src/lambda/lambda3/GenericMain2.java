package lambda.lambda3;

import lambda.lambda3.GenericMain1.NumberFunction;

public class GenericMain2 {

  public static void main(String[] args) {
    ObjectFunction upperCase = String::toUpperCase;
    String result1 = (String) upperCase.apply("hello");
    System.out.println("result1 = " + result1);

    NumberFunction square = n -> n * n;
    Integer result2 = square.apply(5);
    System.out.println("result2 = " + result2);
  }

  @FunctionalInterface
  interface ObjectFunction {

    String apply(String s);
  }

}