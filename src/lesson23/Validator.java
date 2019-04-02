package lesson23;

public final class Validator {
    private String name;
    //    1. initialize final field + static
    private final static int checkCount = 10;

    public Validator(String name) {
        this.name = name;
    }

    public final boolean validate (){

        System.out.println("logic 1");
        return  false;
    }







//    2. initialize final field  - static
//    public Validator(String name, int checkCount) {
//        this.name = name;
//        this.checkCount = checkCount;
//    }

//    cannot change final
//    public void test(){
//        checkCount = 10;
//    }

    public String getName() {
        return name;
    }

    public int getCheckCount() {
        return checkCount;
    }

}
