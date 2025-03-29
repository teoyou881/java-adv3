package methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRefEx4 {

  public static void main(String[] args) {

    List<Person> personList = List.of(
        new Person("a"),
        new Person("b")
        , new Person("c")
    );

    List<String> people = mapPersonToString(personList, Person::getName);
    System.out.println("people = " + people);

    List<String> appliedString = mapStringToString(people, String::toUpperCase);
    System.out.println("appliedString = " + appliedString);
  }

  static List<String> mapPersonToString(List<Person> personList, Function<Person, String> func) {
    List<String> result = new ArrayList<>();
    for (Person p : personList) {
      String applied = func.apply(p);
      result.add(applied);
    }
    return result;
  }

  static List<String> mapStringToString(List<String> strings, Function<String, String> func) {
    List<String> result = new ArrayList<>();
    for (String s : strings) {
      String applied = func.apply(s);
      result.add(applied);
    }
    return result;
  }
}
