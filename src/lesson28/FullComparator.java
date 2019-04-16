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
        System.out.println("FullComparator is used");

        if (o1.getChannelName() == null && o2.getChannelName() != null)
            return 1;
        else if (o1.getChannelName() != null && o2.getChannelName() == null)
            return -1;
        else if (o1.getChannelName() == null && o2.getChannelName() == null)
            return 0;
        else if (!o1.getChannelName().equals(o2.getChannelName()))
            return o1.getChannelName().compareTo(o2.getChannelName());

        else if (o1.getFingerprint() == null && o2.getFingerprint() != null)
            return 1;
        else if (o1.getFingerprint() != null && o2.getFingerprint() == null)
            return -1;
        else if (o1.getFingerprint() == null && o2.getFingerprint() == null)
            return 0;
        else if (!o1.getFingerprint().equals(o2.getFingerprint()))
            return o1.getFingerprint().compareTo(o2.getFingerprint());

        else index = comparator.compare(o1, o2);

        return index;
    }

}
