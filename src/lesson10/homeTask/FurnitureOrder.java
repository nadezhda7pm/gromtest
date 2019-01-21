package lesson10.homeTask;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if ((getShipFromCity().equals("Киев") || getShipFromCity().equals("Львов")) && (getBasePrice() >= 500) && (!getCustomerOwned().getName().equals("Тест")))
            setDateConfirmed(new Date());
    }

    @Override
    public void calculatePrice() {
        double totalPrice;
        if (getBasePrice() < 5000) {
            totalPrice = getBasePrice() + (getBasePrice() * 0.05);
        } else
            totalPrice = getBasePrice() + (getBasePrice() * 0.02);

        setTotalPrice(totalPrice);
    }
}
