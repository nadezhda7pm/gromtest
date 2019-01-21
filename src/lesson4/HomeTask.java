package lesson4;

public class HomeTask {
    public static void main(String[] args) {
        System.out.println(concat("yes", "no", "maybe"));
        System.out.println(findDivCount((short) 1, (short) 10, 2));
        System.out.println( compareSums(2147483647, 2147483647, 2, 4) );
    }

    public static String concat(String a, String b, String c) {
        String res = a + b + c;
        return res;
    }

    public static int findDivCount(short a, short b, int n) {
        // n > 0, 0 <= a <= b

        int count = 0;
        for (int i = a; i <= b; i++) {
            if ((i % n) == 0)
                count++;
        }
        return count;
    }

    public static boolean compareSums(int a, int b, int c, int d){
       long sum1 = sum(a, b);
        long sum2 = sum(c, d);
        return sum1 > sum2 ? true : false;
    }

    public static long sum(int from, int to){
        long sum = 0;
        for (long i = from; i <= to; i++){
            sum += i;
        }
        return sum;
    }
}
