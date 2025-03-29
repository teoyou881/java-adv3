package methodref;

import java.util.function.Supplier;

public class MethodRefEx1 {

  public static void main(String[] args) {
    // 1. Static method reference
    Supplier<String> staticMethod1 = () -> Person.greeting();
    Supplier<String> staticMethod2 = Person::greeting; // Class::staticMethod

    System.out.println("staticMethod1: " + staticMethod1.get());
    System.out.println("staticMethod2: " + staticMethod2.get());

    // 2. Instance method reference of a specific object
    Person person = new Person("Kim");
    Supplier<String> instanceMethod1 = () -> person.introduce();
    Supplier<String> instanceMethod2 = person::introduce; // object::instanceMethod

    System.out.println("instanceMethod1: " + instanceMethod1.get());
    System.out.println("instanceMethod2: " + instanceMethod2.get());

    // 3. Constructor reference
    Supplier<Person> newPerson1 = () -> new Person();
    Supplier<Person> newPerson2 = Person::new; // Class::new

    System.out.println("newPerson1: " + newPerson1.get());
    System.out.println("newPerson2: " + newPerson2.get());
  }
}
