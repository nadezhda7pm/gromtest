package lesson17;

public class Solution {
    public static void main(String[] args) {
        String str1 = " d ff f tre t word word1 3343we 12  longA longA loooongC longD swq! e hgjl n ihf ";
        String str2 = " word word word t 3343we word  long1 longA longA longA long3 long4 swq! e hgjl n ihf ";
        String str3 = " 3343we ";
        String str4 = "3343we test teeeeeeest";
        String str5 = "";


        System.out.println(maxWord(str1));
        System.out.println(minWord(str1));
        System.out.println(maxWord(str3));
        System.out.println(minWord(str3));
        System.out.println(maxWord(str4));
        System.out.println(minWord(str4));
        System.out.println(maxWord(str5));
        System.out.println(minWord(str5));

        System.out.println("__________________________________");
        System.out.println(mostCountedWord(str1));
        System.out.println(mostCountedWord(str2));


        System.out.println("__________________________________");

        String[] address = new String[12];

        address[0] = "http://www.test.com"; //true
        address[1] = "https://www.test.com"; //true
        address[2] = "http://test1.com"; //true
        address[3] = "https://test1.com"; //true
        address[4] = "http://1www.test.com"; //false
        address[5] = "https://1www.test.com"; //false
        address[6] = "http://tes/t.com"; //false
        address[7] = "https://tes/t.com"; //false
        address[8] = "http://te.st.com"; //false
        address[9] = "https://te.st.com"; //false
        address[10] = "http://test.org"; //true
        address[11] = "https://test.net"; //true

        for (String a : address) {
                System.out.println(validate(a));
        }

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
                    if (Character.isLetter(ch)) {
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
            if (isWord(word) && word.length() >= maxWord.length()) {
                maxWord = word;
            }
        }
        return !maxWord.isEmpty() ? maxWord : null;
    }

    public static String minWord(String input) {
        input = input.trim();
        if (input.isEmpty())
            return null;

        else {
            String[] words = input.split(" ");
            String minWord = "";

            for (String word : words) {
                if (isWord(word)) {
                    minWord = word;
                    break;
                }
            }

            for (String word : words) {
                if (isWord(word) && word.length() < minWord.length())
                    minWord = word;
            }
            return !minWord.isEmpty() ? minWord : null;
        }
    }

    public static String mostCountedWord(String input) {
//        count and return number of repetitions for a word
//        compare the number of repetitions for each word in the array
//        and  find the word with the biggest number of repetitions
//        if there are a few mostCountedWord, return the first one

        input = input.trim();
        String mostCountedWord = null;
        if (input != null || !input.isEmpty()) {
            String[] words = input.split(" ");
            int count = 0;

            for (int i = 0; i < words.length; i++) {
                if (countEqualWords(words[i], words) > count) {
                    count = countEqualWords(words[i], words);
                    mostCountedWord = words[i];
                }
            }
        }
        return mostCountedWord;

    }

    private static boolean isWord(String word) {
        boolean isWord = false;
        int c = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLetter(ch)) {
                c++;
            }
        }
        if (!word.isEmpty() && c == word.length())
            isWord = true;
        return isWord;
    }

    private static int countEqualWords(String word, String[] words) {
        int count = 0;
        for (String w : words) {
            if (isWord(w) && w.equals(word))
                count++;
        }
        return count;
    }


    public static boolean validate(String address) {
        boolean addressValidated = false;
        String substr = new String("");

//       verify domain zone
        if (address.indexOf(".com") == (address.length() - 4) ||
                address.indexOf(".org") == (address.length() - 4) ||
                address.indexOf(".net") == (address.length() - 4))
            addressValidated = true;
        else {
            return addressValidated = false;
        }

//        verify how the address starts
        if (address.startsWith("http://") && (address.indexOf("www.") == 7)) {
            addressValidated = true;
            substr = address.substring(11, (address.length() - 4));
        } else if (address.startsWith("https://") && (address.indexOf("www.") == 8)) {
            addressValidated = true;
            substr = address.substring(12, (address.length() - 4));
        } else if (address.startsWith("http://")) {
            addressValidated = true;
            substr = address.substring(7, (address.length() - 4));
        } else if (address.startsWith("https://")) {
            addressValidated = true;
            substr = address.substring(8, (address.length() - 4));
        } else {
            return addressValidated = false;
        }

//        verify special characters and . in the address body
        for (int i = 0; i < substr.length(); i++) {
            char ch = substr.charAt(i);
            if (Character.isLetter(ch) || Character.isDigit(ch)) {
                addressValidated = true;
            } else {
                return addressValidated = false;
            }
        }return addressValidated;
    }

}