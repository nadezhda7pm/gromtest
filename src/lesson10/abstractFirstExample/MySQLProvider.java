package lesson10.abstractFirstExample;

public class MySQLProvider extends DbProvider{

    @Override
    void connectToDb(){
        //logic for MySQL
    }

    @Override
    void disconnectFromDb(){
        //logic for MySQL
    }
}
