package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
////                if channelName not equal  - compare it
////                if channelName is equal - check fingerprint
////                if fingerprint not equal  - compare it
////                if fingerprint is equal - check dateCreated
////                if dateCreated not equal  - compare it
////                if dateCreated is equal - objects are equal

    DateComparator comparator = new DateComparator();
    int index;

    @Override
    public int compare(Capability o1, Capability o2) {
        if (!o1.getChannelName().equals(o2.getChannelName())) {
            o1.getChannelName().compareTo(o2.getChannelName());
        } else if (!o1.getFingerprint().equals(o2.getFingerprint())) {
            o1.getFingerprint().compareTo(o2.getFingerprint());
        } else if (o1.getDateCreated().equals(o2.getDateCreated())) {
            return 0;
        } else
            index = comparator.compare(o1, o2);
        return index;
    }

}
