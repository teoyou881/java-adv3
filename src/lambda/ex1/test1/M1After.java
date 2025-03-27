package lambda.ex1.test1;

public class M1After {

  static void greet(Greeting greeting) {
    greeting.run();
  }

  public static void main(String[] args) {

    greet("Morning");
    greet("Afternoon");
    greet("Evening");

  }

  static void greet(String str) {
    System.out.println("=== start ===");
    System.out.println("Good " + str);
    System.out.println("=== end ===");
  }

}
