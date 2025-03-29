package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamLoopMain {

  public static void main(String[] args) {
    List<Student> students = List.of(
        new Student("Apple", 100),
        new Student("Banana", 80),
        new Student("Berry", 50),
        new Student("Tomato", 40)
    );

    List<String> list = MyStreamV3.of(students).filter(s -> s.getScore() >= 80)
        .map(Student::getName).toList();

    // external iteration
    for (String s : list) {
      System.out.println(s);
    }

    //add
    MyStreamV3.of(students).filter(s -> s.getScore() >= 80)
        .map(Student::getName).toList().forEach(name -> System.out.println("name = " + name));
  }
}
