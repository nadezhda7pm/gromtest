package lesson8.phones;

public class Android extends Phone {
    String androidVersion;
    int screenSize;
    String secretDeviseCode;

    public Android(int price, double weight, String countryProduced, String androidVersion, int screenSize, String secretDeviseCode) {
        super(price, weight, countryProduced);
        // this - reference to the current class object
        // super - reference to the parent class object
        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        this.secretDeviseCode = secretDeviseCode;
    }

    void installNewAndroidVersion() {
        System.out.println("installNewAndroidVersion invoked ...");
    }

}
