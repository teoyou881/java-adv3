package lambda.lambda1;

import lambda.Procedure;

public class InstanceMain {

  public static void main(String[] args) {
    Procedure procedure1 = new Procedure() {

      @Override
      public void run() {
        System.out.println("hello!");
      }
    };

    System.out.println("procedure1.getClass() = " + procedure1.getClass());
    System.out.println("procedure1.instance = " + procedure1);
//procedure1.getClass() = class lambda.lambda1.InstanceMain$1
//procedure1.instance = lambda.lambda1.InstanceMain$1@7291c18f

    Procedure procedure2 = () -> {
      System.out.println("hello!");
    };
    System.out.println("procedure2.getClass() = " + procedure2.getClass());
    System.out.println("procedure2.instance = " + procedure2);
    //procedure2.getClass() = class lambda.lambda1.InstanceMain$$Lambda/0x0000025fbc003600
    //procedure2.instance = lambda.lambda1.InstanceMain$$Lambda/0x0000025fbc003600@7cc355be
  }

}
