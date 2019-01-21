package lesson9.utils;

public class Checker {
    //90%____
//    public - always available
//    private - available only inside the class
//    10%____
//    default - (package-private)
//    protected - default + in inherited
//    _____________________________________________
    // private - available only inside the class
    // default - (package-private)
    // protected - default + in inherited
    // public - always available


    int companyNamesValidatedCount = 0;

   public boolean checkCompanyName(String companyName){
//        if (companyName == "Google" || companyName == "Amazon")
//            return false;
//        return true;

       if (companyNamesValidatedCount > 10)
           return false;

       companyNamesValidatedCount++;
        return companyName != "Google" && companyName != "Amazon";
    }
}
