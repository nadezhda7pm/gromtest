package lesson8.HomeTask;

public class Demo {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 7, 2, 4, 9, 8, 7, 1};
        int[] numbers2 = {2, 4, 7, 2, 4, 9, 8, 7, 100};

        Adder adder = new Adder();
        adder.check(numbers);
        adder.add(5, 7);

        System.out.println(adder.check(numbers));
        System.out.println(adder.check(numbers2));

        System.out.println(adder.add(5, 7));
    }
}
