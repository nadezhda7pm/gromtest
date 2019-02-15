package lesson18;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String str1 = new String(" 11 word 1w . 13   15 ");
        System.out.println(Arrays.toString(findNumbers(str1)));
    }


    public static int[] findNumbers(String text) {
        String[] words = text.split(" ");


        int count = 0;
        for (String w : words) {
            if (isNumber(w)) {
                count++;
            }
        }

        int[] res = new int[count];
        int j = 0;

        for (String w : words) {
            try {
                res[j] = Integer.parseInt(w);
                j++;
            } catch (Exception e) {
                System.out.println("not a number");
            }
        }return res;
    }

    private static boolean isNumber(String word) {
        boolean isNumber = false;
        int c = 0;
        if (!word.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (Character.isDigit(ch)) {
                    c++;
                }
            }
        }
        if (!word.isEmpty() && c == word.length()) {
            isNumber = true;
        }
        return isNumber;
    }

}
