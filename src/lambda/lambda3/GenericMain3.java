package lambda.lambda3;

public class GenericMain3 {

  public static void main(String[] args) {
    ObjectFunction upperCase = new ObjectFunction() {
      @Override
      public String apply(String s) {
        return s.toUpperCase();
      }
    };
    String result1 = (String) upperCase.apply("hello");
    System.out.println("result1 = " + result1);
  }

  @FunctionalInterface
  interface ObjectFunction {

    String apply(String s);
  }

}