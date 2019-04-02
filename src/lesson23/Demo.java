package lesson23;

public class Demo {
    public static void main(String[] args) {
        Validator validator = new Validator("user");
        System.out.println(validator.getCheckCount());

        Validator validator2 = new Validator("company");
        System.out.println(validator2.getCheckCount());
    }
}
