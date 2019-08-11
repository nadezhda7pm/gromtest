package lesson32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadFromKeyboard {

    public static void main(String[] args) throws IOException {

        readKeyboardWithIOSrteam();
        // readKeyboardWithScanner();

    }


    private static void readKeyboardWithScanner() {

        Scanner scanner = new Scanner(System.in);

        int n = 3;
        System.out.println("Please enter your name");
        while (n > 0) {
            String name = scanner.nextLine();
            //scanner.close();
            if (validation(name)) {
                System.out.println("Hello, " + name + "!");
            }
            n--;
        }

        if (n == 0) scanner.close();
    }

    private static void readKeyboardWithIOSrteam() throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int n = 5;
        System.out.println("Please enter your name");

        while (n > 0) {
            String name = br.readLine();
            if (validation(name)) {
                System.out.println("Hello, " + name + "!");
                System.out.println("Thank you!!!");
            }
            n--;
        }
    }


    private static boolean validation(String name) {

        char[] chars = name.toCharArray();

        boolean result = false;

        if (chars.length == 0) {
            System.out.println("You did not enter your name");
        } else {
            for (char c : chars) {
                if (!Character.isLetter(c)) {
                    System.out.println("Please enter one word. Specials characters are not allowed.");
                    return false;
                } else
                    result = true;
            }
        }
        return result;

    }


}
