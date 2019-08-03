package lesson30.task2;

import java.util.ArrayList;
import java.util.List;

public class FirmDAO {

private static List<Firm> firms;


    public FirmDAO() {

        firms = new ArrayList<>();

    }

    public Firm add (Firm f){
        firms.add(f);
        return f;
    }

    public static List<Firm> getFirms() {
        return firms;
    }
}
