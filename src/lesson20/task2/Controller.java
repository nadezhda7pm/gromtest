package lesson20.task2;

import lesson20.task2.exceptions.BadRequestException;
import lesson20.task2.exceptions.InternalServerException;
import lesson20.task2.exceptions.LimitExceeded;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save (Transaction transaction) throws BadRequestException, InternalServerException {

        return transactionDAO.save(transaction);
    }

    Transaction[] transactionList (){

        return transactionDAO.transactionList();
    }

    Transaction[] transactionList (String city) throws  BadRequestException{


        return transactionDAO.transactionList(city);
    }


    Transaction[] transactionList (int amount)throws  BadRequestException{

        return transactionDAO.transactionList(amount);
    }


}
