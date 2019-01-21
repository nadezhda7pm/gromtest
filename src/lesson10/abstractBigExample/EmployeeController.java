package lesson10.abstractBigExample;

import java.sql.SQLOutput;

public class EmployeeController {
    private Employee[] employees = new Employee[100];

    void paySalaryToEmployees() {
        for (Employee employee : employees) {
            employee.paySalary();
            System.out.println("Salary was paid successfully to " + employee.getName() + " employee");
        }
    }

        /*void paySalaryToEmployees(){
            for (Employee employee : employees){
               if (employee instanceof DeveloperEmployee){
                   int newBalance = employee.getBankAccount().getBalance() + employee.getSalaryPerMonth() + 1000;
                   employee.getBankAccount().setBalance(newBalance);
               }else if (employee instanceof ManagerEmployee){
                   int newBalance = employee.getBankAccount().getBalance() + employee.getSalaryPerMonth();
                   newBalance += newBalance * 0.25;
                   employee.getBankAccount().setBalance(newBalance);
               }else if ()
                System.out.println("Salary was paid successfully to " + employee.getName() + " employee");
            }*/
}
