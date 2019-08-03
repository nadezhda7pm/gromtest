package lesson30.task2;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {


    private static List<Employee> employees = new ArrayList<>();


    public EmployeeDAO() {
        employees = new ArrayList<>();
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static Employee contains (Employee e){
            return employees.contains(e) ? e : null;
    }



}

