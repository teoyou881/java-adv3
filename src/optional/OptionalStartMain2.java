package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalStartMain2 {

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

    Optional<String> optName = findNameById(id);
    String name = optName.orElse("UNKNOWN");
    System.out.println(id + ": " + name.toUpperCase());
  }

  static Optional<String> findNameById(Long id) {
    String findName = map.get(id);
    return Optional.ofNullable(findName);
  }
}
