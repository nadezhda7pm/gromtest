package lesson8.HomeTask.Other;

public class Demo {

   static Parent createHighestParent() {
        int[] parents = {207, 186, 190, 183, 159, 198};
        int max = parents[0];
        for (int el : parents) {
            if (el > max)
                max = el;
        }
        Parent parent = new Parent(max);
        return parent ;
    }

   static Child createLowestChild() {
        int[] children = {153, 98, 104, 180, 170, 86};
        int min = children[0];
        for (int el : children) {
            if (el < min)
                min = el;
        }
        Child child = new Child(min);
        return child;
    }
}
