package stream.collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.reducing;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class DonStreamMain2 {

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
    Map<Integer, List<Student>> collect1 = students.stream()
        .collect(groupingBy(Student::getGrade));
    System.out.println("collect1 = " + collect1);

    // Step 2: Find the top scoring student in each grade using reducing
    HashMap<Integer, Optional<Student>> collect2 = students.stream().collect(groupingBy(
        Student::getGrade,
        HashMap::new,
        reducing((s1, s2) -> s1.getScore() > s2.getScore() ? s1 : s2)));
    System.out.println("collect2 = " + collect2);

    // Step 3: Find the top scoring student in each grade using maxBy
    HashMap<Integer, Optional<Student>> collect3 = students.stream().collect(groupingBy(
        Student::getGrade,
        HashMap::new,
        // Collectors.maxBy((s1, s2) -> s1.getScore() > s2.getScore() ? 1 : -1)
        // Collectors.maxBy(Comparator.comparingInt(student -> student.getScore()))
        // maxBy((s1, s2) -> Math.max(s1.getScore(), s2.getScore()))));
        maxBy(Comparator.comparingInt(Student::getScore))));
    System.out.println("collect3 = " + collect3);

    // Step 4: Get only the name of the top scoring student in each grade
    // (groupingBy -> maxBy -> extracting name with collectingAndThen)
    HashMap<Integer, String> collect4 = students.stream().collect(groupingBy(
        Student::getGrade,
        HashMap::new,
        collectingAndThen(
            maxBy(Comparator.comparingInt(Student::getScore)),
            sOpt -> sOpt.get().getName())));
    System.out.println("collect4 = " + collect4);
  }
}
