package lambda.lambda6;

public class OuterMain {

  private String message = "outer class";

  public static void main(String[] args) {
    OuterMain outerMain = new OuterMain();
    System.out.println("outer class = " + outerMain);
    System.out.println("=========================================");
    outerMain.execute();
  }

  public void execute() {
    //1. anonymous class
    Runnable r = new Runnable() {

      private String message = "anonymous class";

      public void run() {
        //In an anonymous class,
        //this refers to the anonymous class itself.
        // It has its own separate context from the outer class.
        System.out.println("[anonymous class] this = " + this);
        System.out.println("[anonymous class] this.class  = " + this.getClass());
        System.out.println("[anonymous class] this.message. = " + this.message);
      }
    };

    //lambda expression
    //In a lambda expression,
    //this refers to the instance of the class in which the lambda is declared.
    //In other words, a lambda expression does not have its own context;
    //it retains the context of the class where it is declared.
    Runnable r2 = () -> {
      System.out.println("[anonymous class] this = " + this);
      System.out.println("[anonymous class] this.class  = " + this.getClass());
      System.out.println("[anonymous class] this.message. = " + this.message);
    };

    r.run();
    System.out.println("=========================================");
    r2.run();
  }


}
