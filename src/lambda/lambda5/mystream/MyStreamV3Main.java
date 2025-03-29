package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamV3Main {

  public static void main(String[] args) {
    List<Student> students = List.of(
        new Student("Apple", 100),
        new Student("Banana", 80),
        new Student("Berry", 50),
        new Student("Tomato", 40)
    );

    // Extract names of students who scored 80 or above
    List<String> result1 = ex1(students);
    System.out.println("result1 = " + result1);

    // Extract uppercase names of students who scored 80 or above and have names with 5 characters
    List<String> result2 = ex2(students);
    System.out.println("result2 = " + result2);
  }

  static List<String> ex1(List<Student> students) {
    return MyStreamV3.of(students)
        .filter(s -> s.getScore() >= 80)
        .map(s -> s.getName())
        .toList();
  }

  static List<String> ex2(List<Student> students) {
    return MyStreamV3.of(students)
        .filter(s -> s.getScore() >= 80)
        .filter(s -> s.getName().length() == 5)
        .map(s -> s.getName())
        .map(name -> name.toUpperCase())
        .toList();
  }
}
