package lesson28;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {

        if (o1.getDateCreated() == null && o2.getDateCreated() != null){
            return 1;
        } else if (o1.getDateCreated() != null && o2.getDateCreated() == null){
            return -1;
        } else if (o1.getDateCreated() == null && o2.getDateCreated() == null){
            return 0;
        } else if (o1.getDateCreated().compareTo(o2.getDateCreated()) < 0)
            return 1;
        else if (o1.getDateCreated().compareTo(o2.getDateCreated()) == 0)
            return 0;
        else
            return -1;
    }
}
