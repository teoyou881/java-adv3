package lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {

  public static void main(String[] args) {
    IntFunction<String> function = x -> "number: " + x;
    System.out.println("function = " + function.apply(4));

    ToIntFunction<String> toIntFunction = s -> s.length();
    System.out.println("toIntFunction = " + toIntFunction.applyAsInt("hihihi"));

    IntToLongFunction intToLongFunction = x -> x * 102;

    System.out.println("intToLongFunction = " + intToLongFunction.applyAsLong(10));

    
  }


}
