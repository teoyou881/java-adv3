package stream.collectors;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DonStreamMain1 {

  public static void main(String[] args) {
    List<Student> students = List.of(
        new Student("Kim", 1, 85),
        new Student("Park", 1, 70),
        new Student("Lee", 2, 70),
        new Student("Han", 2, 90),
        new Student("Hoon", 3, 90),
        new Student("Ha", 3, 89)
    );

    // Step 1: Group students by grade
    Map<Integer, List<Student>> collect1_1 = students.stream()
        .collect(Collectors.groupingBy(Student::getGrade, Collectors.toList()));
    System.out.println("collect1_1 = " + collect1_1);

    // toList() is optional in downstream
    Map<Integer, List<Student>> collect1_2 = students.stream()
        .collect(Collectors.groupingBy(Student::getGrade));
    System.out.println("collect1_2 = " + collect1_2);

    // Step 2: Group students by grade and map to their names
    Map<String, List<String>> collect2 = students.stream().
        collect(Collectors.groupingBy(
            s -> s.getGrade() + "grade",
            LinkedHashMap::new,
            Collectors.mapping(Student::getName, Collectors.toList())));
    System.out.println("collect2 = " + collect2);

    // Step 3: Count students in each grade
    LinkedHashMap<Integer, Long> collect3 = students.stream()
        .collect(Collectors.groupingBy(
            Student::getGrade,
            LinkedHashMap::new,
            Collectors.counting()));
    System.out.println("collect3 = " + collect3);

    // Step 4: Average score per grade
    LinkedHashMap<Integer, Double> collect4 = students.stream()
        .collect(Collectors.groupingBy(
            Student::getGrade,
            LinkedHashMap::new,
            Collectors.averagingDouble(Student::getScore)));
    System.out.println("collect4 = " + collect4);
  }
}
