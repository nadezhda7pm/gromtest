package lesson12;

public class Main {

    public static void main(String[] args) {
        Bank euBank = new EUBank(1222, "Sweden", Currency.EUR, 100, 1400, 4, 444343434);
        Bank chinaBank = new ChinaBank(1343, "China", Currency.USD, 200, 6400, 3, 443434);
        Bank usBank = new USBank(127, "USA", Currency.EUR, 700, 7800, 2, 554343434);

        User userX = new User(1001, "Denis", 12200, 40, "GMD", 1500, usBank);

        User user1 = new User(1001, "Erica", 12200, 40, "GMD", 1500, usBank);
        User user2 = new User(1002, "Ann", 100, 30, "Ann", 2000, usBank);
        User user3 = new User(1003, "John", 1500, 20, "GMD", 3000, euBank);
        User user4 = new User(1004, "Tom", 12200, 40, "ABC", 1500, euBank);
        User user5 = new User(1005, "Kate", 12200, 40, "BBN", 1500, chinaBank);
        User user6 = new User(1006, "Bob", 1700, 40, "GMD", 2750, chinaBank);

        User[] users = new User[]{user1, user2, user3, user4, user5, user6, null};

        BankSystem bankSystem = new UkrainianBankSystem();

        int n = 1;
        for (User user : users) {

            if (user != null) {
                System.out.println("user " + n + " " + user.getName());

                bankSystem.withdraw(user, 150);
                System.out.println(user.getBalance());

                bankSystem.fund(user, 1300);
                System.out.println(user.getBalance());

                bankSystem.paySalary(user);
                System.out.println(user.getBalance());

                bankSystem.transferMoney(userX, user, 200);
                System.out.println(user.getBalance());
                System.out.println("userX balance: " + userX.getBalance());

                bankSystem.transferMoney(user, userX, 300);
                System.out.println(user.getBalance());
                System.out.println("userX balance: " + userX.getBalance());

                System.out.println();
                n++;
            } else
                System.out.println("there's empty user");

        }


//    BankSystem bankSystem = new UkrainianBankSystem();
//    bankSystem.withdraw(user, 150);
//
//        System.out.println(user.getBalance());

    }
}
