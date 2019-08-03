package lesson30.task2;

import java.util.Objects;
import java.util.Set;

public class Department {
    private DepartmentType type;
    private Set<Employee> employees;


    public Department(DepartmentType type) {
        this.type = type;
    }

    public Department(DepartmentType type, Set<Employee> employees) {
        this.type = type;
        this.employees = employees;
    }

    public DepartmentType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return type == that.type &&
                Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {

        return Objects.hash(type, employees);
    }

    @Override
    public String toString() {
        return "Department{" +
                "type=" + type +
                '}';
    }
}
