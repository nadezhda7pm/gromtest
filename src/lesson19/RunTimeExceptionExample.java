package lesson19;

public class RunTimeExceptionExample {
    public static void main(String[] args) {
        //arithmetic exception
        arithmeticException(2);

        try {
            arithmeticException(0);
        }catch (ArithmeticException e){
            System.out.println("something wrong");
        }




    }

    private static void arithmeticException(int a){
        System.out.println(10/a);
    }

}
