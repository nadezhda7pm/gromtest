package lesson20.task2;

import lesson20.task2.exceptions.BadRequestException;
import lesson20.task2.exceptions.InternalServerException;
import lesson20.task2.exceptions.LimitExceeded;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
//        if amount sum > limit
//        if sum of tr amounts for one day > day limit
//        if q-ty of trs for a day > limit
//        if city is not allowed BadRequestException
//        if there's no space InternalsServerException

        validate(transaction);
        int i = 0;
        for (Transaction t : transactions) {
            if (t == null) {
                transactions[i] = transaction;
                return transactions[i];
            }
            i++;
        }
        throw new InternalServerException("Not enough space to save transaction " + transaction.getId());
    }

    private void validate(Transaction transaction) throws BadRequestException {

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        for (Transaction tr : transactions) {
            if (tr != null && tr.getId() == transaction.getId())
                throw new BadRequestException("Transaction with the following id already exists: " + transaction.getId());
        }

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            if (tr != null) {
                sum += tr.getAmount();
                count++;
            }
        }

        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");

        if (count >= utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");

        invalidCity(transaction);

    }

    public Transaction[] transactionList() throws BadRequestException {

        int count = 0;
        for (Transaction t : transactions) {
            if (t == null)
                count++;
        }
        if (count == (transactions.length + 1)) throw new BadRequestException("Transactions list  is empty");
        return transactions;
    }

    public Transaction[] transactionList(String city) throws BadRequestException {

        invalidCity(city);

        int count = 0;
        int c = 0;
        for (Transaction t : transactions) {
            if (t != null && t.getCity().equals(city))
                count++;
            if (t == null)
                c++;
        }

        if (c == (transactions.length + 1)) throw new BadRequestException("Transactions list empty");
        if (count == 0) throw new BadRequestException("No transactions found with city " + city);


        Transaction[] transactionsWithProperCity = new Transaction[count];
        int i = 0;
        int j = 0;
        for (Transaction t : transactions) {
            if (t != null && t.getCity().equals(city)) {
                transactionsWithProperCity[j] = transactions[i];
                j++;
            }
            i++;
        }
        return transactionsWithProperCity;
    }


    public Transaction[] transactionList(int amount) throws BadRequestException {

        if (0 >= amount || amount > utils.getLimitSimpleTransactionAmount())
            throw new BadRequestException("Amount " + amount + " is not allowed amount for a simple transaction. Max allowed transaction amount is " + utils.getLimitSimpleTransactionAmount());

        int count = 0;
        int c = 0;
        for (Transaction t : transactions) {
            if (t != null && t.getAmount() == amount)
                count++;
            if (t == null)
                c++;
        }
        if (c == (transactions.length + 1)) throw new BadRequestException("Transactions list empty");
        if (count == 0) throw new BadRequestException("No transactions found with amount " + amount);

        Transaction[] transactionsWithProperAmount = new Transaction[count];
        int i = 0;
        int j = 0;
        for (Transaction t : transactions) {
            if (t != null && t.getAmount() == amount) {
                transactionsWithProperAmount[j] = transactions[i];
                j++;
            }
            i++;
        }
        return transactionsWithProperAmount;
    }

    private void invalidCity (Transaction transaction) throws BadRequestException{
        for (String city : utils.getCities()) {
            if (city != null && city.equals(transaction.getCity()))
                return;
        }
        throw new BadRequestException("City " + transaction.getCity() + " is not allowed for transactions. Allowed cities are: " + Arrays.toString(utils.getCities()));
    }

    private void invalidCity (String city) throws BadRequestException {
        for (String c : utils.getCities()) {
            if (c != null && c.equals(city))
                return;
        }
        throw new BadRequestException("City " + city + " is not allowed for transactions. Allowed cities are: " + Arrays.toString(utils.getCities()));
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
