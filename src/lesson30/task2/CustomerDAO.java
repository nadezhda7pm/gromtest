package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class CustomerDAO {


    private static Set<Customer> customers;


    public CustomerDAO() {
        customers = new HashSet<>();
    }

    public static Set<Customer> getCustomers() {
        return customers;
    }

    public static Customer getCustomerByName(String name) {
        if (customers != null)
        for (Customer c : customers){
            if (c != null && c.getName().equals(name))
        return c;
        }
        return null;
    }

//    public Customer add (Customer c){
//        customers.add(c);
//        return c;
//    }
//
//    public Customer remove (Customer c){
//        customers.remove(c);
//        return c;
//    }
//
//    public Customer contains (Customer c){
//        customers.contains(c);
//        return c;
//    }


}
