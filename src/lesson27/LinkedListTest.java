package lesson27;


import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args){

        System.out.println(Arrays.deepToString(useList()));
    }


    public static Order[] useList() {

        Order order1 = new Order(1, 100, "EUR", "book", "555");
        Order order2 = new Order(2, 100, "UA", "cup", "dd89");
        Order order3 = new Order(3, 100, "USD", "book", "555");
        Order order4 = new Order(4, 400, "EUR", "pen", "555");
        Order order5 = new Order(5, 300, "UA", "cup", "90");
        Order order6 = new Order(6, 700, "USD", "book", "709");


        LinkedList<Order> list = new LinkedList<>();
        LinkedList<Order> list2 = new LinkedList<>();

        list.add(order1);
        list.add(order2);
        list.clear();
        list.add(order1);
        list.add(0, order3);
        list.remove(0);

        list2.add(order5);
        list2.add(order6);
        list2.add(order1);
        list2.add(order2);
        list2.add(order2);
        list2.add(order5);

        list.addAll(list2);

        list.set(2, order4);
        System.out.println(list.contains(order3));
        System.out.println(list.contains(order4));

        return list.subList(1,6).toArray(new Order[5]);
    }
}