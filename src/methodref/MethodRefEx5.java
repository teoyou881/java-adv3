package methodref;

import java.util.List;
import lambda.lambda5.mystream.MyStreamV3;

public class MethodRefEx5 {

  public static void main(String[] args) {
    List<Person> personList = List.of(
        new Person("a"),
        new Person("b")
        , new Person("c")
    );

    List<String> list = MyStreamV3.of(personList)
        .map(Person::introduce)
        .map(String::toUpperCase)
        .toList();
  }
}
