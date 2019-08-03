package lesson30.task2;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Employee {
    private String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private Set<Project> projects;

    public Employee(String firstName, String lastName, Date dateHired, Position position, Department department, Set<Project> projects) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
        this.projects = projects;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Department getDepartment() {
        return department;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(dateHired, employee.dateHired) &&
                position == employee.position &&
                Objects.equals(department, employee.department) &&
                Objects.equals(projects, employee.projects);
    }

    @Override
    public int hashCode() {

        return Objects.hash(firstName, lastName, dateHired, position, department, projects);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                '}';
    }
}
