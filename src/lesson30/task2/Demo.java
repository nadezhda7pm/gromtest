package lesson30.task2;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {

        Controller controller = new Controller();

        Firm firm1 = new Firm(new Date(117, 06, 06));
        Firm firm2 = new Firm(new Date(117, 06, 06));
        Firm firm3 = new Firm(new Date(117, 06, 06));

        controller.getFirmDAO().add(firm1);
        controller.getFirmDAO().add(firm2);
        controller.getFirmDAO().add(firm3);



        Customer customer1 = new Customer("Cola", "USA", 2000);
        Customer customer2 = new Customer("Pepsi", "UK", 400);
        Customer customer3 = new Customer("Sprite", "Poland", 1600);
        Customer customer4 = new Customer("XXX", "Poland", 1600);

        CustomerDAO.getCustomers().add(customer1);
        CustomerDAO.getCustomers().add(customer2);
        CustomerDAO.getCustomers().add(customer3);
        CustomerDAO.getCustomers().add(customer4);



        Project project1 = new Project("Mars", CustomerDAO.getCustomerByName("Cola"));
        Project project2 = new Project("Venus", CustomerDAO.getCustomerByName("Pepsi"));
        Project project3 = new Project("Saturn", CustomerDAO.getCustomerByName("Sprite"));
        Project project4 = new Project("Mercury", CustomerDAO.getCustomerByName("Cola"));

        ProjectDAO.getProjects().add(project1);
        ProjectDAO.getProjects().add(project2);
        ProjectDAO.getProjects().add(project3);
        ProjectDAO.getProjects().add(project4);


        Set<Project> projectsEmployee1 = new HashSet<>();
        projectsEmployee1.add(ProjectDAO.getProjectByName("Venus"));
        projectsEmployee1.add(ProjectDAO.getProjectByName("Mars"));

        Set<Project> projectsEmployee2 = new HashSet<>();
        projectsEmployee2.add(ProjectDAO.getProjectByName("Saturn"));
        projectsEmployee2.add(ProjectDAO.getProjectByName("Mars"));

        Set<Project> projectsEmployee3 = new HashSet<>();
        projectsEmployee3.add(ProjectDAO.getProjectByName("Mercury"));
        projectsEmployee3.add(ProjectDAO.getProjectByName("Saturn"));

        Set<Project> projectsEmployee4 = new HashSet<>();
        projectsEmployee4.add(ProjectDAO.getProjectByName("Venus"));
        projectsEmployee4.add(ProjectDAO.getProjectByName("Saturn"));

        Set<Project> projectsEmployee5 = new HashSet<>();

        Set<Project> projectsEmployee6 = new HashSet<>();
        projectsEmployee6.add(ProjectDAO.getProjectByName("Venus"));





        Employee employee1 = new Employee("Tom", "Black", new Date() ,Position.FINANCE, new Department(DepartmentType.FINANCE), projectsEmployee1);
        Employee employee2 = new Employee("Jack", "White", new Date(118, 10, 23), Position.MANAGER, new Department(DepartmentType.MANAGERS), projectsEmployee2);
        Employee employee3 = new Employee("Kate", "Sweet", new Date(119, 07, 11), Position.DEVELOPER, new Department(DepartmentType.DEVELOPERS), projectsEmployee3);
        Employee employee4 = new Employee("Bill", "Torn", new Date(119, 03, 01), Position.MANAGER, new Department(DepartmentType.MANAGERS), projectsEmployee4);
        Employee employee5 = new Employee("John", "Red", new Date(116, 10, 16), Position.DEVELOPER, new Department(DepartmentType.DEVELOPERS), projectsEmployee1);
        Employee employee6 = new Employee("Ann", "Sweet", new Date(112, 07, 19), Position.DEVELOPER, new Department(DepartmentType.DEVELOPERS), projectsEmployee4);
        Employee employee7 = new Employee("El", "Sweet", new Date(112, 07, 19), Position.DEVELOPER, new Department(DepartmentType.DEVELOPERS), projectsEmployee5);
        Employee employee8 = new Employee("Tl", "Sweet", new Date(112, 07, 19), Position.TEAM_LEAD, new Department(DepartmentType.MANAGERS), projectsEmployee4);
        Employee employee9 = new Employee("T2", "Sweet", new Date(112, 07, 19), Position.TEAM_LEAD, new Department(DepartmentType.MANAGERS), projectsEmployee6);
        Employee employee10 = new Employee("T3", "Sweet", new Date(112, 07, 19), Position.TEAM_LEAD, new Department(DepartmentType.MANAGERS), projectsEmployee5);

        EmployeeDAO.getEmployees().add(employee1);
        EmployeeDAO.getEmployees().add(employee2);
        EmployeeDAO.getEmployees().add(employee3);
        EmployeeDAO.getEmployees().add(employee4);
        EmployeeDAO.getEmployees().add(employee5);
        EmployeeDAO.getEmployees().add(employee6);
        EmployeeDAO.getEmployees().add(employee7);
        EmployeeDAO.getEmployees().add(employee8);
        EmployeeDAO.getEmployees().add(employee9);
        EmployeeDAO.getEmployees().add(employee10);



        Set<Employee> devs = new HashSet<>();
        devs.add(employee3);
        devs.add(employee5);
        devs.add(employee6);

        Set<Employee> mans = new HashSet<>();
        devs.add(employee2);
        devs.add(employee4);

        Set<Employee> fins = new HashSet<>();
        devs.add(employee1);




        Department developers = new Department(DepartmentType.DEVELOPERS, devs);
        Department managers = new Department(DepartmentType.MANAGERS, mans);
        Department finance = new Department(DepartmentType.FINANCE, fins);

        DepartmentDAO.getDepartments().add(developers);
        DepartmentDAO.getDepartments().add(managers);
        DepartmentDAO.getDepartments().add(finance);





//   employeesByProject:

        System.out.println(controller.employeesByProject("Mercury"));
        System.out.println(controller.employeesByProject("Cola"));
        System.out.println(controller.employeesByProject("Venus"));


// projectsByEmployee

        System.out.println(controller.projectsByEmployee(employee1));
        System.out.println(controller.projectsByEmployee(employee1));
      //  System.out.println(controller.projectsByEmployee(null));
        System.out.println(controller.projectsByEmployee(employee7));


// employeesByDepartmentWithoutProject

        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.DEVELOPERS));
        System.out.println(controller.employeesByDepartmentWithoutProject(DepartmentType.MANAGERS));
       // System.out.println(controller.employeesByDepartmentWithoutProject(null));


// employeesWithoutProject

        System.out.println(controller.employeesWithoutProject());


// employeesByTeamLead

        System.out.println("---------------------------------------------");
        System.out.println(controller.employeesByTeamLead(employee8));
        System.out.println(controller.employeesByTeamLead(employee9));
        System.out.println(controller.employeesByTeamLead(employee10));


// teamLeadsByEmployee

        System.out.println("******************************************************");
        System.out.println(controller.teamLeadsByEmployee(employee3));
        System.out.println(controller.teamLeadsByEmployee(employee6));
        System.out.println(controller.teamLeadsByEmployee(employee7));


// employeesByCustomerProjects

        System.out.println("=====================================================");
        System.out.println(controller.employeesByCustomerProjects(customer1));
        System.out.println(controller.employeesByCustomerProjects(customer2));
        System.out.println(controller.employeesByCustomerProjects(customer3));
        System.out.println(controller.employeesByCustomerProjects(customer4));



    }


}
