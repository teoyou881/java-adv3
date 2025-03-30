package optional;

import java.util.Optional;

public class OptionalRetrievalMain {

  public static void main(String[] args) {
    // Example: Prepare a non-empty Optional and an empty Optional
    Optional<String> optValue = Optional.of("Hello");
    Optional<String> optEmpty = Optional.empty();

    // isPresent(): returns true if value is present
    System.out.println("=== 1. isPresent() / isEmpty() ===");
    System.out.println("optValue.isPresent() = " + optValue.isPresent()); // true
    System.out.println("optEmpty.isPresent() = " + optEmpty.isPresent()); // false

    // isEmpty(): returns true if value is not present
    System.out.println("optEmpty.isEmpty() = " + optEmpty.isEmpty());

    // get(): retrieves the value directly; throws exception if value is absent
    System.out.println("=== 2. get() ===");
    String getValue = optValue.get();
    System.out.println("getValue = " + getValue);
    // String getValue2 = optEmpty.get(); // Exception will occur → commented out

    // orElse(): returns value if present, otherwise returns the default
    System.out.println("=== 3. orElse() ===");
    String value1 = optValue.orElse("Default");
    String empty1 = optEmpty.orElse("Default");
    System.out.println("value1 = " + value1);
    System.out.println("empty1 = " + empty1);

    // orElseGet(): if value is absent, executes Supplier to generate default
    System.out.println("=== 4. orElseGet() ===");
    String value2 = optValue.orElseGet(() -> {
      System.out.println("Lambda called - optValue");
      return "New Value";
    });
    String empty2 = optEmpty.orElseGet(() -> {
      System.out.println("Lambda called - optEmpty");
      return "New Value";
    });
    System.out.println("value2 = " + value2);
    System.out.println("empty2 = " + empty2);

    // orElseThrow(): returns value if present, throws exception if absent
    System.out.println("=== 5. orElseThrow() ===");
    String value3 = optValue.orElseThrow(() -> new RuntimeException("Value not found!"));
    System.out.println("value3 = " + value3);

    try {
      // optEmpty has no value, so exception will be thrown
      String empty3 = optEmpty.orElseThrow(() -> new RuntimeException("Value not found!"));
      System.out.println("empty3 = " + empty3); // This line won't be executed
    } catch (Exception e) {
      System.out.println("Exception occurred: " + e.getMessage());
    }

    // or(): returns original Optional if present; otherwise, returns alternate Optional
    System.out.println("=== 6. or() ===");
    Optional<String> result1 = optValue.or(() -> Optional.of("Fallback"));
    System.out.println(result1); // Optional[Hello], value exists → returns original

    Optional<String> result2 = optEmpty.or(() -> Optional.of("Fallback"));
    System.out.println(result2); // Optional[Fallback], value was absent → returns fallback
  }
}
