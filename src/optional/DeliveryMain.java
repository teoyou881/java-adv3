package optional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import optional.model.Delivery;
import optional.model.Order;

// If Delivery is null or the delivery is canceled, return "No Delivery"
public class DeliveryMain {

  static Map<Long, Order> orderRepository = new HashMap<>();

  static {
    orderRepository.put(1L, new Order(1L, new Delivery("Delivered", false)));
    orderRepository.put(2L, new Order(2L, new Delivery("Shipping", false)));
    orderRepository.put(3L, new Order(3L, new Delivery("Shipping", true)));
    orderRepository.put(4L, new Order(4L, null));
  }

  public static void main(String[] args) {
    System.out.println("1 = " + getDeliveryStatus(1L));
    System.out.println("2 = " + getDeliveryStatus(2L));
    System.out.println("3 = " + getDeliveryStatus(3L));
    System.out.println("4 = " + getDeliveryStatus(4L));

    List<String> strings = useStream(orderRepository);
    strings.forEach(System.out::println);


  }

  private static List<String> useStream(Map<Long, Order> orderRepository) {
    return orderRepository.entrySet().stream().map(
        entry -> {
          Long orderId = entry.getKey();
          String status = Optional.ofNullable(entry.getValue())
              .map(Order::getDelivery)
              .filter(delivery -> !delivery.isCanceled())
              .map(Delivery::getStatus)
              .orElseGet(() -> "no shipping");

          return orderId + " " + status;
        }
    ).toList();
  }

  private static String getDeliveryStatus(long orderId) {
    return findOrder(orderId).map(Order::getDelivery)
        .filter(delivery -> !delivery.isCanceled())
        .map(Delivery::getStatus)
        .orElseGet(() -> "Do not shipping");

  }

//  static String getDeliveryStatus(Long orderId) {
//    return findOrder(orderId)
//        .map(Order::getDelivery)                        // Order → Delivery
//        .filter(delivery -> !delivery.isCanceled())     // filter out canceled deliveries
//        .map(Delivery::getStatus)                       // Delivery → String
//        .orElse("No Delivery");                         // return fallback message
//  }
//
//  static List<String> useStream() {
//    return orderRepository.entrySet().stream().map(
//        e -> {
//          Long id = e.getKey();
//          String status = Optional.ofNullable(e.getValue()).map(Order::getDelivery)
//              .filter(delivery -> !delivery.isCanceled()).map(Delivery::getStatus)
//              .orElse("No Delivery");
//          return id + "= " + status;
//        }
//    ).toList();
//  }

  static Optional<Order> findOrder(Long orderId) {
    return Optional.ofNullable(orderRepository.get(orderId));
  }
}
