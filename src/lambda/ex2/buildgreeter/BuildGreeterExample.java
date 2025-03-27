package lambda.ex2.buildgreeter;

public class BuildGreeterExample {

  // Higher-order function: takes a greeting string and returns a "new function"
  public static StringFunction buildGreeter(String greeting) {
    // TODO: implement
    return (s) -> {
      return greeting + ", " + s;
    };
  }

  public static void main(String[] args) {
    // TODO: implement
    StringFunction hello = buildGreeter("Hello");
    StringFunction hi = buildGreeter("Hi");

    System.out.println(hello.apply("Java"));
    System.out.println(hi.apply("Lambda"));
  }
}
