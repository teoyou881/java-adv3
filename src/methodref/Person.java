package methodref;

public class Person {

  private String name;

  // Constructor
  public Person() {
    this("Unknown");
  }

  // Constructor with parameter
  public Person(String name) {
    this.name = name;
  }

  // Static method
  public static String greeting() {
    return "Hello";
  }

  // Static method with parameter
  public static String greetingWithName(String name) {
    return "Hello " + name;
  }

  public String getName() {
    return name;
  }

  // Instance method
  public String introduce() {
    return "I am " + name;
  }

  // Instance method with parameter
  public String introduceWithNumber(int number) {
    return "I am " + name + ", my number is " + number;
  }
}
