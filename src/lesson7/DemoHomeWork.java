package lesson7;

import lesson6.Order;

import java.util.Date;

public class DemoHomeWork {
    public static void main(String[] args) {

    }

    static Order createOrder() {
        Order order1 = new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
        return order1;
    }

    static Order createOrderAndCallMethods() {
        Order order2 = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        order2.confirmOrder();
        order2.checkPrice();
        order2.isValidType();
        return order2;
    }
}
