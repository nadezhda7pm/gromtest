package lesson2;

public class SumAndDivision {
    public static void main(String[] args) {

        int a = 0;

        for (int i = 0; i <= 1000; i++) {
            a += i;
        }

        int b = a / 1234;
        int c = a % 1234;

        boolean x = c > b;

        System.out.println(x);
    }
}
