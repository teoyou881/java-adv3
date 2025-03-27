package lambda.lambda4;

import java.util.function.Consumer;

public class ConsumerMain {

  public static void main(String[] args) {
    //anonymous
    Consumer<String> consumer1 = new Consumer<String>() {
      @Override
      public void accept(String string) {
        System.out.println("string = " + string);
      }
    };

    consumer1.accept("hello");

    //lambda
    Consumer<String> consumer2 = (s) -> System.out.println("s = " + s);
    consumer2.accept("hello");
  }

}
