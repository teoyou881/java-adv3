package methodref;

import java.util.function.Function;

// Add parameters
public class MethodRefEx2 {

  public static void main(String[] args) {
    // 1. Static method reference
    Function<String, String> staticMethod1 = name -> Person.greetingWithName(name);
    Function<String, String> staticMethod2 = Person::greetingWithName; // Class::staticMethod

    System.out.println("staticMethod1 = " + staticMethod1.apply("Kim"));
    System.out.println("staticMethod2 = " + staticMethod2.apply("Kim"));

    // 2. Instance method reference (specific object's instance method)
    Person instance = new Person("Kim");
    Function<Integer, String> instanceMethod1 = n -> instance.introduceWithNumber(n);
    Function<Integer, String> instanceMethod2 = instance::introduceWithNumber; // object::instanceMethod

    System.out.println("instanceMethod1 = " + instanceMethod1.apply(1));
    System.out.println("instanceMethod2 = " + instanceMethod2.apply(1));

    // 3. Constructor reference
    Function<String, Person> supplier1 = name -> new Person(name);
    Function<String, Person> supplier2 = Person::new; // Class::new

    System.out.println("newPerson = " + supplier1.apply("Kim"));
    System.out.println("newPerson = " + supplier2.apply("Lee"));
  }
}
