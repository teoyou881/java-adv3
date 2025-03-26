package lambda.start.Ex0;

public class Ex0Main {

  public static void helloJava() {
    System.out.println("Program started");
    System.out.println("Hello Java");
    System.out.println("Program ended");
  }

  public static void helloSpring() {
    System.out.println("Program started");
    System.out.println("Hello Spring");
    System.out.println("Program ended");
  }

  public static void main(String[] args) {
    helloJava();
    helloSpring();
  }

  public static class Ex0RefMain {

    public static void hello() {
      System.out.println("Program started"); // common part
      // variable part
      System.out.println("Hello Java");
      System.out.println("Hello Spring");
      // end of variable part
      System.out.println("Program ended"); // common part
    }

    public static void hello(String str) {
      System.out.println("Program started");
      System.out.println(str);
      System.out.println("Program ended");
    }

    public static void main(String[] args) {
      hello("Hello Java");
      hello("Hello Spring");
    }
  }
}
