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
        //4. order is null - not in this case
        //orders [4] = null;


        for (Order order : orders) {
            order.validateOrder();
            order.calculatePrice();
            order.setTotalPrice(2000);
            System.out.println(order.toString());
        }

        System.out.println();

        // ElectronicsOrder:
        //1. getBasePrice < 100;
        //2. getCustomerOwned().getGender().equals("Мужской")
        //3. getShipFromCity().equals("London")



        Customer customer1 = new Customer("Bob", "Киев", "Мужской");
        Customer customer2 = new Customer("Ann", "Киев", "Женский");

        ElectronicsOrder electronicsOrder10 = new ElectronicsOrder("eo10", new Date(), "Киев", "Киев", 50, customer2, 1);
        ElectronicsOrder electronicsOrder11 = new ElectronicsOrder("eo11", new Date(), "Киев", "Киев", 700, customer1, 1);
        ElectronicsOrder electronicsOrder12 = new ElectronicsOrder("eo12", new Date(), "London", "Киев", 700, customer2, 1);




        Order[] eOrders = new Order[]{electronicsOrder10, electronicsOrder11, electronicsOrder12};

        for (Order order : eOrders) {
            order.validateOrder();
            order.calculatePrice();
            order.setTotalPrice(2000);
            System.out.println(order.toString());
        }





    }
}
