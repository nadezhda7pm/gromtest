package lesson2;

public class SumOfNumbers {
    public static void main(String[] args) {

        long a = 0;
        for (int i = 0; i <= 10000000; i++) {
            a += i;
        }
        System.out.println(a);
    }
}
