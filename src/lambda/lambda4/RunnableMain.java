package lambda.lambda4;

public class RunnableMain {

  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("RunnableMain.run");
      }
    };
    runnable.run();

    Runnable runnable1 = () -> System.out.println("RunnableMain.run1");
    runnable1.run();
  }


}
