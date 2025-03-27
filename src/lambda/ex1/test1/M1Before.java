package lambda.ex1.test1;

public class M1Before {

  public static void greetMorning() {
    System.out.println("=== start ===");
    System.out.println("Good Morning!");
    System.out.println("=== end ===");
  }

  public static void greetAfternoon() {
    System.out.println("=== start ===");
    System.out.println("Good Afternoon!");
    System.out.println("=== end ===");
  }

  public static void greetEvening() {
    System.out.println("=== start ===");
    System.out.println("Good Evening!");
    System.out.println("=== end ===");
  }

  public static void main(String[] args) {
    greetMorning();
    greetAfternoon();
    greetEvening();
  }
}