package lesson32.hometask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {


    public Integer readNumbers() throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        Integer result = 0;
        int n = 2;
        while (n >= 0) {

            String inputNumbers = br.readLine();

            if (validateInput(inputNumbers) != null) {
                for (Integer i : validateInput(inputNumbers)) {
       //             if (i != null)
                        result += i;
                }
                    System.out.println(result);
                return result;
            }
            else{

                if (n == 0){
                    System.out.println("“Your numbers are wrong. Number of attempts exceeded”");
                }
                else
                    System.out.println("“Your numbers are wrong. You have " + n + " attempts to try again");
                }n--;
            }return result;
        }



    private ArrayList<Integer> validateInput(String input) {

        ArrayList<Integer> validNumbers = new ArrayList<>();
        String[] strs = input.split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();

        if (strs.length > 10) {
            System.out.println("more than 10");
            return null;
        }


            for (String s : strs){
                try{Integer.parseInt(s);}
                catch (Exception e){
                    System.out.println("Could not parse");
                return null;
            }
            if (Integer.parseInt(s) <= 100) {
                validNumbers.add(Integer.parseInt(s));
            }
            else {
                System.out.println(">100");
                    return null;
            }
        }

        return validNumbers;
    }


}
