package lesson31;

public class Demo {

    public static void main(String[] args) {

        String text1 = "Ooooo! It's a lovely day!!!!' ";
        String text2 = "";
        String text3 = "12345 678 900";
        String text4 = null;
        String text5 = "aa 11 a1   a* aaa aa aaaaa a a aa af af_f ";

        Solution solution = new Solution();

        System.out.println(solution.countSymbols(text1));
        System.out.println(solution.countSymbols(text2));
        System.out.println(solution.countSymbols(text3));
        System.out.println(solution.countSymbols(text4));
        System.out.println(solution.countSymbols(text5));

        System.out.println("---------------------------------------------------------------");

        System.out.println(solution.words(text1));
        System.out.println(solution.words(text2));
        System.out.println(solution.words(text3));
        System.out.println(solution.words(text4));
        System.out.println(solution.words(text5));
    }
}
