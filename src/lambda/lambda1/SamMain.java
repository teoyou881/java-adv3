package lambda.lambda1;

public class SamMain {

  public static void main(String[] args) {
    SamInterface sam = () -> System.out.println("Hello World");
    sam.run();

//    NotSamInterface notSamInterface = ()->{
//      System.out.println("Hello World");
//    }
  }

}
