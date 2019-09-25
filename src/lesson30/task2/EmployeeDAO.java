package lesson30.task2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeDAO {


    private static List<Employee> employees = new ArrayList<>();


    public EmployeeDAO() {
        employees = new ArrayList<>();
    }

    public static List<Employee> getEmployees() {
        return employees;
    }

    public static Employee contains(Employee e) {
        return employees.contains(e) ? e : null;
    }


    public Set<Employee> employeesByProject(String projectName) {

        Set<Employee> employeesByProject = new HashSet<>();

        for (Employee e : getEmployees()) {
            if (e != null && e.getProjects() != null && e.getProjects().contains(ProjectDAO.getProjectByName(projectName)))
                employeesByProject.add(e);
        }
        return employeesByProject;
    }


    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {

        Set<Employee> employeesByDepartmentWithoutProject = new HashSet<>();

            for (Employee e : employeesWithoutProject()) {
                if (e.getDepartment().getType() == departmentType)
                    employeesByDepartmentWithoutProject.add(e);
            }
        return employeesByDepartmentWithoutProject;
    }


    public Set<Employee> employeesWithoutProject() {

        Set<Employee> employeesWithoutProject = new HashSet<>();

        for (Employee e : getEmployees()) {
            if (e != null && e.getProjects() != null && e.getProjects().isEmpty())
                employeesWithoutProject.add(e);
        }

        return employeesWithoutProject;
    }


    public Set<Employee> employeesByTeamLead(Employee lead) {

        Set<Employee> employeesByTeamLead = new HashSet<>();

        if (lead != null && lead.getProjects() != null)
            for (Project p : lead.getProjects()) {
                for (Employee e : employeesByProject(p.getName())) {
                    if (e != null && e.getPosition() != Position.TEAM_LEAD)
                        employeesByTeamLead.add(e);
                }
            }
        return employeesByTeamLead;
    }


    public Set<Employee> teamLeadsByEmployee(Employee employee) {

        Set<Employee> teamLeadsByEmployee = new HashSet<>();

        for (Employee e : employeesByProjectEmployee(employee)) {
            if (e != null && e.getPosition().equals(Position.TEAM_LEAD))
                teamLeadsByEmployee.add(e);
        }
        teamLeadsByEmployee.remove(employee); // this employee can be teamLead,too
        return teamLeadsByEmployee;
    }


    public Set<Employee> employeesByProjectEmployee(Employee employee) {

        ProjectDAO projectDAO = new ProjectDAO();

        Set<Employee> employeesByProjectEmployee = new HashSet<>();

        for (Project p : projectDAO.projectsByEmployee(employee)) {
            employeesByProjectEmployee.addAll(employeesByProject(p.getName()));
        }

        employeesByProjectEmployee.remove(employee);

        return employeesByProjectEmployee;
    }


    public Set<Employee> employeesByCustomerProjects(Customer customer) {

        Set<Employee> employeesByCustomerProjects = new HashSet<>();

        for (Project p : ProjectDAO.getProjects()) {
            if (p != null && p.getCustomer().equals(customer))
                employeesByCustomerProjects.addAll(employeesByProject(p.getName()));
        }
        return employeesByCustomerProjects;
    }

}

