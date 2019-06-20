package lesson30.task1;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {
        //check whether withdraw is possible
        //check limit
        //check if enough money
        //withdraw money

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "sdsd");
    }

    public void printWithdrawalErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + "from user" + user.toString());
    }

    public void printFundErrorMsg(int amount, User user) {
        System.err.println("Can't fund money " + amount + "for user" + user.toString());
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFunding(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "sdsd");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        // withdraw money from fromUser
        // fund money to toUser

        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency())
            return;
        else
        if (!checkWithdraw(fromUser, amount))
            return;
        else
        if (!checkFunding(toUser, amount))
            return;
        else{
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);}

        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "sdsd");
    }

    @Override
    public void paySalary(User user) {
        if (!checkFunding (user, user.getSalary()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());

        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "sdsd");
    }


    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + amount * user.getBank().getCommission(amount) > limit) {
            printWithdrawalErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private boolean checkFunding(User user, int amount) {
        if (amount > user.getBank().getLimitOfFunding()) {
            printFundErrorMsg(amount, user);
            return false;
        }
        return true;
    }


    private Transaction createAndSaveTransaction (Date dateCreated, TransactionType type, int amount, String descr){
        Random random = new Random();
        Transaction tr = new Transaction (random.nextInt(), dateCreated, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
