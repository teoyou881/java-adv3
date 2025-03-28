package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

public class Ex2_Student {

  public static void main(String[] args) {
    // Extract names of students who scored 80 or higher
    List<Student> students = List.of(
        new Student("Apple", 100),
        new Student("Banana", 80),
        new Student("Berry", 50),
        new Student("Tomato", 40)
    );

    List<String> directResult = direct(students);
    System.out.println("directResult = " + directResult);

    List<String> lambdaResult = lambda(students);
    System.out.println("lambdaResult = " + lambdaResult);
  }

  private static List<String> direct(List<Student> students) {
    // TODO implement logic
    List<String> result = new ArrayList<>();
    for (Student student : students) {
      if (student.getScore() >= 80) {
        result.add(student.getName());
      }
    }
    return result;
  }

  private static List<String> lambda(List<Student> students) {
    // TODO implement logic
    List<Student> filteredList = GenericFilter.filter(students,
        student -> student.getScore() >= 80);
    return GenericMapper.map(filteredList, s -> s.getName());
  }
}
