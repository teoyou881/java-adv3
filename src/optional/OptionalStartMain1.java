package optional;

import java.util.HashMap;
import java.util.Map;

public class OptionalStartMain1 {

  private static final Map<Long, String> map = new HashMap<>();

  static {
    map.put(1L, "Kim");
    map.put(2L, "Seo");
    // 3L is not added, so it will be used as an ID that cannot be found
  }

  public static void main(String[] args) {
    findAndPrint(1L); // case where value exists
    findAndPrint(3L); // case where value does not exist
  }

  // If the name exists, print it in uppercase; otherwise, print "UNKNOWN"
  static void findAndPrint(Long id) {
    String name = findNameById(id);

    // 1. This would cause NullPointerException
    // System.out.println("name = " + name.toUpperCase());

    // 2. Null check using if-statement
    if (name != null) {
      System.out.println(id + ": " + name.toUpperCase());
    } else {
      System.out.println(id + ": " + "UNKNOWN");
    }
  }

  static String findNameById(Long id) {
    return map.get(id);
  }
}
