package lambda.lambda3;

public class TargetType1 {

  public static void main(String[] args) {
    // Direct lambda assignment: no problem
    FunctionA functionA = i -> "value = " + i;
    FunctionB functionB = i -> "value = " + i;

    // Assigning an already created FunctionA instance to FunctionB: not allowed
    // FunctionB targetB = functionA; // Compile error!
  }

  @FunctionalInterface
  interface FunctionA {

    String apply(String s);
  }

  @FunctionalInterface
  interface FunctionB {

    String apply(Integer integer);
  }
}
