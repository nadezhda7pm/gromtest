package lesson30.task2;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class Firm {
    private Date DateFounded;
    private Set<Department> departments;
    private Set<Customer> customers;

    public Firm(Date dateFounded) {
        DateFounded = dateFounded;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Firm)) return false;
        Firm firm = (Firm) o;
        return Objects.equals(DateFounded, firm.DateFounded) &&
                Objects.equals(departments, firm.departments) &&
                Objects.equals(customers, firm.customers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(DateFounded, departments, customers);
    }


    @Override
    public String toString() {
        return "Firm{" +
                "DateFounded=" + DateFounded +
                '}';
    }
}
