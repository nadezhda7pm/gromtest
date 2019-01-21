package lesson10.abstractBigExample;

import java.util.SplittableRandom;

public abstract class Employee {
    private String name;
    private int age;
    private int yearsOfExperience;

    private String curPosition;

    private  int salaryPerMonth;
    private BankAccount bankAccount;
    private Company[] companiesWorked = new Company[10];
    private String[] positionsWorked = new String[10];

    abstract void paySalary();

    void changePosiition(String newPosition){
//        save the current position to the historyLog
//        change the position
        saveCurPositionToHistory();
        curPosition = newPosition;
    }

    private void saveCurPositionToHistory(){
        int index = 0;
        for(String pos : positionsWorked){
            if (pos == null){
                positionsWorked[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance(){
        return bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }
}
