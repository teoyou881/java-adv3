package optional;

import java.util.Optional;

public class OptionalCreationMain {

  public static void main(String[] args) {
    // 1. of(): Use when the value is definitely non-null. Throws NullPointerException if null
    String nonNullValue = "Hello Optional!";
    Optional<String> opt1 = Optional.of(nonNullValue);
    System.out.println("opt1 = " + opt1); // Optional[Hello Optional!]

    // 2. ofNullable(): Use when the value might be null
    Optional<String> opt2 = Optional.ofNullable("Hello!");
    Optional<String> opt3 = Optional.ofNullable(null);
    System.out.println("opt2 = " + opt2); // Optional[Hello!]
    System.out.println("opt3 = " + opt3); // Optional.empty

    // 3. empty(): Explicitly create an empty Optional
    Optional<String> opt4 = Optional.empty();
    System.out.println("opt4 = " + opt4); // Optional.empty
  }
}
