package lesson16.homeTask;

public class Solution {
    public static void main(String[] args) {
        String str1 = " word word1 12   thelongestword swq! e hgjl- - -ihf";
        System.out.println(countWords(str1));
        System.out.println(maxWord(str1));
        System.out.println(minWord(str1));


    }

    public static int countWords(String input) {
//        1. split the string into array of words
//        2. check if each word in the array contains proper chars and count if yes

        String[] words = input.split(" ");
        int count = 0;

        for (String word : words) {
            int c = 0;
            if (!word.isEmpty()) {
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if (((ch >= 'A') && (ch <= 'Z')) || ((ch >= 'a') && (ch <= 'z'))) {
                        c++;
                    }
                }
            }
            if (!word.isEmpty() && c == word.length())
                count++;
        }
        return count;
    }

    public static String maxWord(String input) {
        String[] words = input.split(" ");
        String maxWord = "";

        for (String word : words) {
                if (word.length() > maxWord.length()) {
                    maxWord = word;
                }
        }
        return maxWord;
}

    public static String minWord(String input) {
        input = input.trim();
        String[] words = input.split(" ");
        int j = 0;
        String minWord = words[j];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
            if (!word.isEmpty() && word.length() < minWord.length())
                minWord = word;
        }
        }
        return minWord;
    }





}
