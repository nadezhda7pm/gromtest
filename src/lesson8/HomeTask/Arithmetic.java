package lesson8.HomeTask;

public class Arithmetic {

    boolean check(int[] array) {
        int max = array[0];
        for (int el : array) {
            if (el > max)
                max = el;
        }

        int min = array[0];
        for (int el : array) {
            if (el < min)
                min = el;
        }
        return (max + min) > 100;
    }
}
