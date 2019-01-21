package lesson10.homeTask;

        import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer = new Customer("Ann", "Киев", "Женский");

        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("eo1", new Date(), "Киев", "Киев", 700, customer, 1);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("eo2", new Date(), "Харьков", "Киев", 700, customer, 1);

        FurnitureOrder furnitureOrder1 = new FurnitureOrder("fo2", new Date(), "Киев", "Киев", 700, customer, "c1");
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("fo2", new Date(), "Харьков", "Киев", 700, customer, "i1");

        Order[] orders = new Order[4];
        orders [0] = electronicsOrder1;
        orders [1] = electronicsOrder2;
        orders [2] = furnitureOrder1;
        orders [3] = furnitureOrder2;


        for (Order order : orders) {
            order.validateOrder();
            order.calculatePrice();
            order.setTotalPrice(2000);
        }
    }
}
