package lesson25;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO generalDAO = new GeneralDAO();
        Order order = new Order(10);
        generalDAO.validate(order);

        TestClass<String, Order, Long> testClass = new TestClass<>();
        System.out.println(testClass.doSomething1("rrr"));

        int test = 100;
        long variable = 111;
        Long variable2 = new Long(222);

        generalDAO.validate(variable2);
        generalDAO.validate(variable);
        generalDAO.validate(test);

        Order order1 = new Order(1);
        Order order2 = new Order(2);
        Order order11 = new Order(1);

        Long l = new Long(1);
        Long l1 = new Long(111);
        Long l2 = new Long(222222);
        Long l3 = new Long(333);
        Long l4 = new Long(4444);
        Long l5 = new Long(55555);


        Order[] orders = {order1, order2, order11};
        String[] strings = {"a", null, "bb", "ccc", "dd dd", "1", "2"};
        Long[] numbers = {l, l1, l2, l3, l4, l5};

        for (Order el: orders){
            generalDAO.save(el);
        }
        System.out.println(Arrays.deepToString(generalDAO.getAll()) + "one");

        for (String el :  strings){
            generalDAO.save(el);
        }
        System.out.println(Arrays.deepToString(generalDAO.getAll())+ "two");

        generalDAO.save(numbers[0]);
        System.out.println(Arrays.deepToString(generalDAO.getAll())+ "three");

        generalDAO.save(numbers[1]);
        System.out.println(Arrays.deepToString(generalDAO.getAll())+ "four");

        generalDAO.save(numbers[2]);
        System.out.println(Arrays.deepToString(generalDAO.getAll())+ "five");



        for (Long el : numbers){
            generalDAO.save(el);
        }
        System.out.println(Arrays.deepToString(generalDAO.getAll()) + "six");

    }
}
