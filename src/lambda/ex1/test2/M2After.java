package lambda.ex1.test2;

public class M2After {

  public static void main(String[] args) {
    print(10, "kg");
    print(50, "kg");
    print(200, "g");
    print(40, "g");
  }

  public static void print(int weight, String unit) {
    System.out.println("weight: " + weight + unit);
  }
}
