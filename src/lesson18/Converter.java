package lesson18;

public class Converter {
    public static void main(String[] args) {
        System.out.println(intToString(1176541));
        System.out.println(stringToInt("111"));

        System.out.println(stringToInt("111aaa"));
        System.out.println(stringToInt(""));

        System.out.println(intToString(1176541));
        System.out.println(stringToInt("111"));

    }

    public static String intToString (int input){
        return String.valueOf(input);
    }

    public static int stringToInt (String input){
        try {
            return Integer.parseInt(input);
        }catch (Exception e){
            System.out.println(input + " can not be converted to int");
            return 0;
        }
    }

}
