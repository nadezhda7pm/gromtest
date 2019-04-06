package lesson29;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        System.out.println(useHashSet());
    }

    public static Set<Order> useHashSet() {

        Order order1 = new Order(1, 100, "EUR", "book", "555");
        Order order2 = new Order(2, 100, "UA", "cup", "dd89");
        Order order3 = new Order(3, 100, "USD", "book", "555");
        Order order4 = new Order(4, 400, "EUR", "pen", "555");
        Order order5 = new Order(5, 300, "UA", "cup", "90");
        Order order6 = new Order(1, 700, "USD", "book", "709");

        LinkedList<Order> ordersLL = new LinkedList<>();
        ordersLL.add(order5);
        ordersLL.add(order4);
        ordersLL.add(order6);

        Set<Order> orders = new HashSet<Order>();

        orders.add(order1);
        orders.add(order2);
        System.out.println(orders);
        orders.remove(order1);
        System.out.println(orders);
        orders.add(order1);
        orders.add(order6);
        orders.add(order3);
        orders.add(order4);
        System.out.println(orders.size());
        System.out.println(orders);
        orders.retainAll(ordersLL);
        System.out.println(orders.size());
        System.out.println(orders);
        orders.add(order2);
        orders.add(order3);
        orders.add(order5);
        orders.toArray(new Order[5]);

       return orders;

    }
}
