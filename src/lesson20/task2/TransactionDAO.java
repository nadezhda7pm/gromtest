package lesson20.task2;

import lesson20.task2.exceptions.BadRequestException;
import lesson20.task2.exceptions.InternalServerException;
import lesson20.task2.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
//        if city is not allowed BadRequestException
//        if there's no space InternalsServerException

        validate(transaction);
        int i = 0;
        for (Transaction t : transactions) {
            if (t == null) {
                transactions[i] = transaction;
                break;
            }
            i++;
        }
        return transactions[i];
    }

    private void validate(Transaction transaction) throws BadRequestException, InternalServerException, LimitExceeded {

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        int a = 0;
        for (Transaction tr : transactions){
            if (tr != null && tr.getId() == transaction.getId())
                a++;
        }
        if (a > 0) throw new InternalServerException("Transaction with the following id already exists: " + transaction.getId());


        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            if (tr != null) {
                sum += tr.getAmount();
                count++;
            }
        }

        if (sum > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");

        if (count > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");


        int i = 0;
        for (String city : utils.getCities()) {
            if (city != null && city.equals(transaction.getCity()))
                i++;
        }
        if (i < 1) throw new BadRequestException("Wrong city for transaction " + transaction.getId());

        int c = 0;
        for (Transaction t : transactions) {
            if (t == null)
                c++;
        }
        if (c < 1) throw new InternalServerException("Not enough space to save transaction " + transaction.getId());
    }


    public Transaction[] transactionList() {

        return transactions;
    }

    public Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction t : transactions){
            if (t.getCity().equals(city))
                count++;
        }

        Transaction[] transactionsWithProperCity = new Transaction[count];
        int i = 0;
        int j = 0;
        for (Transaction t : transactions){
            if (t.getCity().equals(city)){
                transactionsWithProperCity[j] = transactions[i];
                j++;
            }
                i++;
        }
        return transactionsWithProperCity;
    }


    public Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction t : transactions){
            if (t.getAmount() == amount)
                count++;
        }

        Transaction[] transactionsWithProperAmount = new Transaction[count];
        int i = 0;
        int j = 0;
        for (Transaction t : transactions){
            if (t.getAmount() == amount){
                transactionsWithProperAmount[j] = transactions[i];
                j++;
            }
            i++;
        }
        return transactionsWithProperAmount;
    }


    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }


}
