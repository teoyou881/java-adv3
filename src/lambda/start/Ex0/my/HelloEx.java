package lambda.start.Ex0.my;

public class HelloEx {

  public static void main(String[] args) {
    Java java = new Java("Java");
    Java Spring = new Java("Spring");

    java.hello();
    Spring.hello();
  }

  public static class Java implements Hello {

    private static String name;

    public Java(String name) {
      this.name = name;
    }

    @Override
    public void hello() {
      System.out.println("Program started");
      System.out.println("Hello " + name);
      System.out.println("Program ended");
    }
  }


}
