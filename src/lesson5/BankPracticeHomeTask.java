package lesson5;

import java.util.Arrays;

public class BankPracticeHomeTask {
    public static void main(String[] args) {
        String[] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "John"};
        int[] balances = {100, 500, 8432, -99, 12000, -54, 0};

        System.out.println(Arrays.toString(balances));
        withdraw(names, balances, "Ann", 300);
        System.out.println(Arrays.toString(balances));
        withdraw(names, balances, "Ann", 300);
        System.out.println(Arrays.toString(balances));
    }

    static int withdraw(String[] clients, int[] balances, String client, int amount) {
        //1. find client from array - findClientIndexByName
        //2. withdraw money and return the rest or -1

        return balances[findClientIndexByName(clients, client)] = amount <= balances[findClientIndexByName(clients, client)] ? balances[findClientIndexByName(clients, client)] - amount : -1;
    }

    public static int findClientIndexByName(String[] clients, String client) {
        int clientIndex = 0;
        for (String cl : clients) {
            if (cl == client) {
                break;
            }
            clientIndex++;
        }
        return clientIndex;
    }
}
