package methodref;

import java.util.function.BiFunction;

// Add parameters
public class MethodRefEx6 {

  public static void main(String[] args) {
    // 4. Instance method reference of an arbitrary object (of a specific type)
    Person person = new Person("Kim");

    // Lambda
    BiFunction<Person, Integer, String> fun1 =
        (Person p, Integer number) -> p.introduceWithNumber(number);
    System.out.println("person.introduceWithNumber = " + fun1.apply(person, 1));

    // Method reference: the type becomes the first parameter,
    // and the method is called on that first parameter.
    // Type::methodName
    BiFunction<Person, Integer, String> fun2 = Person::introduceWithNumber;
    System.out.println("person.introduceWithNumber = " + fun2.apply(person, 1));
  }
}