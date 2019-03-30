package lesson20.task2;

import lesson20.task2.exceptions.BadRequestException;
import lesson20.task2.exceptions.InternalServerException;
import lesson20.task2.exceptions.LimitExceeded;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Transaction transaction1 = new Transaction(1, "Kiev", 5, "des1", TransactionType.INCOME, new Date());
        Transaction transaction111 = new Transaction(1, "Kiev", 5, "des1", TransactionType.INCOME, new Date());
        Transaction transaction11111 = new Transaction(1, "Kiev", 5, "des11111", TransactionType.INCOME, new Date());
        Transaction transaction1111 = new Transaction(1111, "Odessa", 41, "des1", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Odessa", 5, "des2", TransactionType.OUTCOME, new Date());
        Transaction transaction22 = new Transaction(22, "Lvov", 10, "des6", TransactionType.INCOME, new Date());
        Transaction transaction3 = new Transaction(3, "Kiev", 10, "des3", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(4, "Kiev", 5, "des4", TransactionType.OUTCOME, new Date());
        Transaction transaction5 = new Transaction(5, "Kiev", 5, "des5", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(6, "Kiev", 10, "des6", TransactionType.INCOME, new Date());
        Transaction transaction7 = new Transaction(7, "Kiev", 10, "des6", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(8, "Kiev", 40, "des6", TransactionType.INCOME, new Date());
        Transaction transaction9 = new Transaction(9, "Kiev", 40, "des6", TransactionType.INCOME, new Date());
        Transaction transaction10 = new Transaction(10, "Kiev", 5, "des6", TransactionType.INCOME, new Date());
        Transaction transaction11 = new Transaction(11, "Kiev", 5, "des6", TransactionType.INCOME, new Date());

        Transaction[] ts = {transaction1, transaction111, transaction1111, transaction11111, transaction2, transaction22, transaction3,
                transaction4, transaction5, transaction6, transaction7, transaction8, transaction9, transaction10, transaction11};

        Controller controller = new Controller();


        controller.transactionList();

        System.out.println(Arrays.toString(controller.transactionList()));

        System.out.println(Arrays.toString(controller.transactionList("Odessa")));

        for (Transaction t : ts) {
            try {
                controller.save(t);
            } catch (BadRequestException e1) {
                System.out.println(e1.getMessage());
            } catch (InternalServerException e2) {
                System.out.println(e2.getMessage());
            }
    }

        System.out.println(Arrays.toString(controller.transactionList()));


        System.out.println(Arrays.toString(controller.transactionList("Odessa")));

        System.out.println(Arrays.toString(controller.transactionList(10)));

        System.out.println(Arrays.toString(controller.transactionList("Vinnytsya")));

        System.out.println(Arrays.toString(controller.transactionList(9000)));

        System.out.println(Arrays.toString(controller.transactionList(null)));
}
}
