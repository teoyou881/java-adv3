package lambda.lambda1;

import lambda.Procedure;

public class LambdaSimple2 {

  public static void main(String[] args) {

    Procedure procedure1 = () -> {
      System.out.println("Hello Lambda");
    };
    procedure1.run();

    Procedure procedure2 = () -> System.out.println("hello Lambda");
    procedure2.run();

  }

}
