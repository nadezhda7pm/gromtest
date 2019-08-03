package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class DepartmentDAO {

private static Set<Department> departments;

    public DepartmentDAO() {
        departments = new HashSet<>();
    }


    public static Set<Department> getDepartments() {
        return departments;
    }
}
