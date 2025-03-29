package methodref;

import java.util.function.Function;

public class MethodRefEx3 {

  public static void main(String[] args) {
    // 4. Instance method reference of an arbitrary object (of a specific type)
    Person person1 = new Person("Kim");
    Person person2 = new Person("Park");
    Person person3 = new Person("Lee");

    // Lambda
    Function<Person, String> fun1 = (Person person) -> person.introduce();
    System.out.println("person1.introduce = " + fun1.apply(person1));
    System.out.println("person2.introduce = " + fun1.apply(person2));
    System.out.println("person3.introduce = " + fun1.apply(person3));

    // Method reference: the type becomes the first parameter, and the method is called on that parameter
    Function<Person, String> fun2 = Person::introduce; // Type::instanceMethod
    System.out.println("person1.introduce = " + fun2.apply(person1));
    System.out.println("person2.introduce = " + fun2.apply(person2));
    System.out.println("person3.introduce = " + fun2.apply(person3));
  }
}
