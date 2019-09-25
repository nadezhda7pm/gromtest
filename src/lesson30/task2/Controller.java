package lesson30.task2;

import java.util.HashSet;
import java.util.Set;

public class Controller {

private EmployeeDAO employeeDAO = new EmployeeDAO();
private ProjectDAO projectDAO = new ProjectDAO();

private CustomerDAO customerDAO = new CustomerDAO();
private DepartmentDAO departmentDAO = new DepartmentDAO();
private FirmDAO firmDAO = new FirmDAO();


    public Set<Employee> employeesByProject(String projectName) {return employeeDAO.employeesByProject(projectName);}


    public Set<Project> projectsByEmployee(Employee employee) {return projectDAO.projectsByEmployee(employee);}


    public Set<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {return employeeDAO.employeesByDepartmentWithoutProject(departmentType);}


    public Set<Employee> employeesWithoutProject() {return employeeDAO.employeesWithoutProject();}


    public Set<Employee> employeesByTeamLead(Employee lead) {return employeeDAO.employeesByTeamLead(lead);}


    public Set<Employee> teamLeadsByEmployee(Employee employee) {return employeeDAO.teamLeadsByEmployee(employee);}


    public Set<Employee> employeesByProjectEmployee(Employee employee) {return employeeDAO.employeesByProjectEmployee(employee);}


    public Set<Employee> employeesByCustomerProjects(Customer customer) {return employeeDAO.employeesByCustomerProjects(customer);}


    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

    public CustomerDAO getCustomerDAO() {
        return customerDAO;
    }

    public DepartmentDAO getDepartmentDAO() {
        return departmentDAO;
    }

    public FirmDAO getFirmDAO() {
        return firmDAO;
    }
}
