package lesson12;

public class UkrainianBankSystem implements BankSystem {


    @Override
    public void withdraw(User user, int amount) {
        //check whether withdraw is possible
        //check limit
        //check if enough money
        //withdraw money

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
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


//        if (checkWithdraw(fromUser, amount) && checkFunding(toUser, amount)) {
//            withdraw(fromUser, amount);
//            fund(toUser, amount);
//        }
//        else
//            if (!checkWithdraw(fromUser, amount))
//                printWithdrawalErrorMsg(amount, fromUser);
//        else
//        printFundErrorMsg(amount,toUser);
    }

    @Override
    public void paySalary(User user) {
        if (!checkFunding (user, user.getSalary()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());
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

}
