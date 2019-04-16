package lesson28;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class DemoComparator {
    public static void main(String[] args) {

        Capability capability2 = new Capability(1005, "test", "rrr", false, new Date(119, 03, 10));
        Capability capability4 = new Capability(900, "atest", "rrr1", false, new Date());
        Capability capability5 = new Capability(900, "btest", "rrr2", false, new Date());
        Capability capability3 = new Capability(900, "ctest", "rrr", true, new Date(118, 03, 06));
        Capability capability1 = new Capability(1001, "test", "rrr", true, new Date(119, 0, 11));
        Capability capability6 = new Capability(900, null, "rrr1", false, new Date());
        Capability capability7 = new Capability(900, "atest", null, false, new Date());
        Capability capability8 = new Capability(900, "atest", "rrr1", false, null);

        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        capabilities.add(capability5);
        capabilities.add(capability6);
        capabilities.add(capability7);
        capabilities.add(capability8);

        System.out.println(capabilities);
        capabilities.sort(new IsActiveComparator());
        System.out.println(capabilities);

        capabilities.sort(new DateComparator());
        System.out.println(capabilities);

        DateComparator comparator = new DateComparator();
        System.out.println(comparator.compare(capability1, capability2));
        System.out.println(comparator.compare(capability1, capability1));
        System.out.println(comparator.compare(capability2, capability1));

        capabilities.sort(new FullComparator());
        System.out.println(capabilities);

    }

}
