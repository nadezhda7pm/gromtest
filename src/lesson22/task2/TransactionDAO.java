package lesson22.task2;

import lesson22.task2.exceptions.BadRequestException;
import lesson22.task2.exceptions.InternalServerException;
import lesson22.task2.exceptions.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];

    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
//        if transaction is null
//        if amount sum > limit
//        if sum of tr amounts for one day > day limit
//        if q-ty of trs for a day > limit
//        if city is not allowed BadRequestException
//        if there's no space InternalsServerException
//        if tr with such id exists

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

        if (transaction == null) throw new BadRequestException("Transaction is null. Can't be saved");

        invalidCity(transaction);

        if (transaction.getAmount() > Utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceeded " + transaction.getId() + ". Can't be saved");

        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction))
                throw new BadRequestException("Duplicate transaction with id: " + transaction.getId());
        }

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            if (tr != null) {
                sum += tr.getAmount();
                count++;
            }
        }

        if (sum + transaction.getAmount() > Utils.getLimitTransactionsPerDayAmount())
            throw new LimitExceeded("Transaction limit per day amount exceeded " + transaction.getId() + ". Can't be saved");

        if (count >= Utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceeded " + transaction.getId() + ". Can't be saved");
    }

    public Transaction[] transactionList() {

        int count = 0;
        for (Transaction t : transactions) {
            if (t != null)
                count++;
        }

        Transaction[] transactionsToReturn = new Transaction[count];

        if (count == 0) return transactionsToReturn;

        int i = 0;
        for (Transaction t : transactions) {
            if (t != null) {
                transactionsToReturn[i] = t;
                i++;
            }
        }
        return transactionsToReturn;
    }

    public Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction t : transactions) {
            if (city != null && t != null && city.equals(t.getCity()))
                count++;
        }

        Transaction[] transactionsWithProperCity = new Transaction[count];

        if (count == 0) return transactionsWithProperCity;

        int i = 0;
        for (Transaction t : transactions) {
            if (t != null && city.equals(t.getCity())) {
                transactionsWithProperCity[i] = t;
                i++;
            }
        }
        return transactionsWithProperCity;
    }


    public Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction t : transactions) {
            if (t != null && t.getAmount() == amount)
                count++;
        }

        Transaction[] transactionsWithProperAmount = new Transaction[count];

        if (count == 0) return transactionsWithProperAmount;

        int i = 0;
        for (Transaction t : transactions) {
            if (t != null && t.getAmount() == amount) {
                transactionsWithProperAmount[i] = t;
                i++;
            }
        }
        return transactionsWithProperAmount;
    }

    private void invalidCity(Transaction transaction) throws BadRequestException {
        for (String city : Utils.getCities()) {
            if (city != null && city.equals(transaction.getCity()))
                return;
        }
        throw new BadRequestException("City " + transaction.getCity() + " is not allowed for transactions. Transaction " + transaction.getId() + " is not saved.");
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
