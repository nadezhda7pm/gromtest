package lesson10.homeTask;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    public int getGuaranteeMonths() {
        return guaranteeMonths;
    }

    @Override
    public void validateOrder() {

        if ((getShipFromCity().equals("Киев") || getShipFromCity().equals("Одесса") || getShipFromCity().equals("Днепр") || getShipFromCity().equals("Харьков")) && (getShipToCity().equals("Киев") || getShipToCity().equals("Одесса") || getShipToCity().equals("Днепр") || getShipToCity().equals("Харьков")) && (getBasePrice() >= 100) && (getCustomerOwned().getGender().equals("Женский")))
        setDateConfirmed(new Date());
    }

    @Override
    public void calculatePrice() {
        double totalPrice;
        if (getShipToCity().equals("Киев") || getShipToCity().equals("Одесса")) {
            totalPrice = getBasePrice() + (getBasePrice() * 0.10);
        } else
            totalPrice = getBasePrice() + (getBasePrice() * 0.15);

        if (getBasePrice() > 1000)
            totalPrice -= totalPrice * 0.05;

        setTotalPrice(totalPrice);
    }


}
