package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStreamV3<T> {

  private List<T> internalList;

  private MyStreamV3(List<T> internalList) {
    this.internalList = internalList;
  }

  //static factory
  public static <T> MyStreamV3<T> of(List<T> internalList) {
    return new MyStreamV3<T>(internalList);
  }

  public MyStreamV3<T> filter(Predicate<T> predicate) {
    List<T> filtered = new ArrayList<>();
    for (T element : internalList) {
      if (predicate.test(element)) {
        filtered.add(element);
      }
    }
    return MyStreamV3.of(filtered);
  }

  // Applies the given function to each element
  public <R> MyStreamV3<R> map(Function<T, R> mapper) {
    List<R> mapped = new ArrayList<>();
    for (T element : internalList) {
      mapped.add(mapper.apply(element));
    }
    return MyStreamV3.of(mapped);
  }

  // Returns the internal list
  public List<T> toList() {
    return internalList;
  }

  //add
  public void forEach(Consumer<T> consumer) {
    for (T t : internalList) {
      consumer.accept(t);
    }
  }
}
