package lambda.ex2.compose;

public class ComposeExample {

  // Higher-order function: takes two functions f1 and f2, and returns a new function
  // that applies f1 first, then f2
  public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {
    // TODO: implement
    return (s) -> f2.transform(f1.transform(s));
  }

  public static void main(String[] args) {
    // f1: convert to uppercase
    MyTransformer toUpper = s -> s.toUpperCase();

    // f2: add "**" to front and back
    MyTransformer addDeco = s -> "**" + s + "**";

    // compose: apply f1 → f2 in order
    MyTransformer composeFunc = compose(toUpper, addDeco);

    // run
    String result = composeFunc.transform("hello");
    System.out.println(result); // "**HELLO**"
  }
}