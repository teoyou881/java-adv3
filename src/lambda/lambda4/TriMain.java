package lambda.lambda4;

public class TriMain {

  public static void main(String[] args) {
    TriFunction<Integer, Integer, Integer, Integer> trifun = (a, b, c) -> a * b * c;
    System.out.println("trifun = " + trifun.apply(4, 3, 5));
  }


  @FunctionalInterface
  interface TriFunction<A, B, C, R> {

    R apply(A a, B b, C c);
  }

}
