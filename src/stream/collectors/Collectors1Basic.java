package stream.collectors;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors1Basic {

  public static void main(String[] args) {

    //basic
    List<String> list = Stream.of("Java", "Spring", "JPA").collect(Collectors.toList());
    System.out.println("list = " + list);

    List<Integer> unmodifiableList = Stream.of(1, 2, 3).collect(Collectors.toUnmodifiableList());
    //UnsupportedOperationException
    //unmodifiableList.add(4);
    System.out.println("unmodifiableList = " + unmodifiableList);

    Set<Integer> set = Stream.of(1, 2, 2, 3, 3, 3).collect(Collectors.toSet());
    //1,2,3
    //remove duplicate
    System.out.println("set = " + set);

    //Specify type
    TreeSet<Integer> treeSet = Stream.of(1, 3, 2, 5, 4, 7, 6, 10)
        .collect(Collectors.toCollection(TreeSet::new));
    System.out.println("treeSet = " + treeSet);
  }

}
