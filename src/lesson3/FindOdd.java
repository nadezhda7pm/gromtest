package lesson3;

public class FindOdd {
    public static void main(String[] args) {

        int a = 0;

        for (int i = 1; i <= 1000; i = i + 2) {
            System.out.println("Found");
            a += i;
        }

        if ( (a * 5) > 5000)
            System.out.println("Bigger");
        else
            System.out.println("Smaller or equal");
    }
}
