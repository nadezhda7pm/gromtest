package lesson1;

import lesson9.Company;

public class FinancialCompany extends Company {
    public static void main(String[] args) {
    }


    public FinancialCompany(String name, String countryFounded) {
        super(name, countryFounded);
    }

    void demonstrateProtectedModifier() {
        System.out.println(this.code);
    }
}
