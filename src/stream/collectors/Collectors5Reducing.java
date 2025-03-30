package stream.collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Collectors5Reducing {

  public static void main(String[] args) {
    List<String> names = List.of("a", "b", "c", "d");

    // Reducing in collectors is mainly used in downstream operations
    // (since Stream already provides reduce)

    // Concatenate all names into a single string
    String joined1 = names.stream()
        .collect(Collectors.reducing((s1, s2) -> s1 + "," + s2)).get();
    System.out.println("joined1 = " + joined1);

    // Using Stream's built-in reduce
    String joined2 = names.stream().reduce((s1, s2) -> s1 + "," + s2)
        .get();
    System.out.println("joined2 = " + joined2);

    // String-specific utility from Collectors
    String joined3 = names.stream().collect(Collectors.joining(","));
    System.out.println("joined3: " + joined3);

    // Using String.join (varargs version)
    //String joined4 = String.join(",", "a", "b", "c", "d");
    String joined4 = String.join(",", names);
    System.out.println("joined4: " + joined4);
  }
}
