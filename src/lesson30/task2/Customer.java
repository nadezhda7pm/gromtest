package lesson30.task2;

import java.util.Objects;

public class Customer {
    private String name;
    private String country;
    private int monthlyPay;


    public Customer(String name, String country, int monthlyPay) {
        this.name = name;
        this.country = country;
        this.monthlyPay = monthlyPay;
    }


    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return monthlyPay == customer.monthlyPay &&
                Objects.equals(name, customer.name) &&
                Objects.equals(country, customer.country);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, country, monthlyPay);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}
