package optional;

import java.util.Optional;

public class OptionalProcessingMain {

  public static void main(String[] args) {
    Optional<String> optValue = Optional.of("Hello");
    Optional<String> optEmpty = Optional.empty();

    // Executes Consumer if value is present; does nothing if absent
    System.out.println("=== 1. ifPresent() ===");
    optValue.ifPresent(v -> System.out.println("optValue: " + v));
    optEmpty.ifPresent(v -> System.out.println("optEmpty: " + v)); // Not executed

    // Executes Consumer if value is present; executes Runnable if absent
    System.out.println("=== 2. ifPresentOrElse() ===");
    optValue.ifPresentOrElse(
        v -> System.out.println("optValue: " + v),
        () -> System.out.println("optValue is empty")
    );
    optEmpty.ifPresentOrElse(
        v -> System.out.println("optEmpty: " + v),
        () -> System.out.println("optEmpty is empty")
    );

    // Applies Function and wraps result in Optional if value exists; else returns Optional.empty()
    System.out.println("=== 3. map() ===");
    Optional<Integer> lengthOpt1 = optValue.map(String::length);
    System.out.println("optValue.map(String::length) = " + lengthOpt1);
    Optional<Integer> lengthOpt2 = optEmpty.map(String::length);
    System.out.println("optEmpty.map(String::length) = " + lengthOpt2);

    // Similar to map(), but removes nested Optionals if already returned as Optional
    System.out.println("=== 4. flatMap() ===");
    System.out.println("[map]");
    // Optional[Hello] -> Optional[Optional[HELLO]]
    Optional<Optional<String>> nestedOpt = optValue.map(o -> Optional.of(o));
    System.out.println("optValue = " + optValue);
    System.out.println("nestedOpt = " + nestedOpt);

    System.out.println("[flatMap]");
    // Optional[Hello] -> Optional[HELLO]
    Optional<String> flattenedOpt = optValue.flatMap(Optional::of);
    System.out.println("optValue = " + optValue);
    System.out.println("flattenedOpt = " + flattenedOpt);

    // Keeps the value if it satisfies the predicate, otherwise returns Optional.empty()
    System.out.println("=== 5. filter() ===");
    Optional<String> filtered1 = optValue.filter(s -> s.startsWith("H"));
    Optional<String> filtered2 = optValue.filter(s -> s.startsWith("X"));
    System.out.println("filter(H) = " + filtered1); // Optional[Hello]
    System.out.println("filter(X) = " + filtered2); // Optional.empty

    // Returns a stream with the value if present; empty stream otherwise
    System.out.println("=== 6. stream() ===");
    optValue.stream()
        .forEach(s -> System.out.println("optValue.stream() -> " + s));

    // No output because value is absent
    optEmpty.stream()
        .forEach(s -> System.out.println("optEmpty.stream() -> " + s));
  }
}
