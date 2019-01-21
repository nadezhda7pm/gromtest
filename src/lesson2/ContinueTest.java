package lesson2;

public class ContinueTest {
    public static void main(String[] args) {

        int test1 = 10;

        //break example
        /*while (test1 > 0) {
            System.out.println(test1);
            System.out.println("...");
            test1 --;
            break;
            }*/

        while (test1 > 0) {
            System.out.println(test1);
            if (test1 == 5)
                //test1 --;
                continue;
            test1 --;

        }
        //test1--;
        System.out.println("done");

    }
}
