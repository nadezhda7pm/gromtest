package lesson31;


import java.util.HashMap;

public class Solution {

    public HashMap<Character, Integer> countSymbols(String text) {

        HashMap<Character, Integer> symbols = new HashMap<>();

        if(text != null) {
            for (char c : text.toCharArray()) {

                if (Character.isLetter(c)) {
                    int count = 0;
                    for (char ch : text.toCharArray()) {
                        if (ch == c)
                            count++;
                    }

                    symbols.put(c, count);
                }
            }
        }

            return symbols;

    }


        public HashMap<String, Integer> words (String text) {

            HashMap<String, Integer> repeatedWords = new HashMap<>();

            if(text != null) {
                String[] allWords = text.split(" ");

                for (String word : allWords) {
                    if (word.length() >= 2 && isWord(word)) {
                        int count = 0;
                        for (String w : allWords) {
                            if (word.equals(w))
                                count++;
                        }
                        repeatedWords.put(word, count);
                    }
                }
            }

                return repeatedWords;
            }



            private boolean isWord (String word){
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


        }