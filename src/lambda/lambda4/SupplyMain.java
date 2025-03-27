package lambda.lambda4;

import java.util.function.Supplier;

public class SupplyMain {

  public static void main(String[] args) {
    Supplier<String> sup = new Supplier<String>() {

      @Override
      public String get() {
        return "hello";
      }
    };
    System.out.println("sup = " + sup.get());

    Supplier<String> supplier = () -> "hello";
    System.out.println("supplier = " + supplier.get());
  }

}
