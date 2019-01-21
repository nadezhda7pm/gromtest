package lesson8.ads;

public class HouseAd extends Ad {
    String ownerName;
    String address;
    double square;
    int flour;

    public HouseAd(long id, int price, String address, double square, int flour) {
        super(id, price);
        this.address = address;
        this.square = square;
        this.flour = flour;
    }

    boolean checkOwnerOfAd(){
        Owners owners = new Owners();
        for(String owner : owners.owners) {
            if (ownerName == owner)
                return true;
        }
        return false;

    }
}
