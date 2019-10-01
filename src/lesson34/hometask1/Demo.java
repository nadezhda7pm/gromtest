package lesson34.hometask1;

public class Demo {

    public static void main(String[] args) throws Exception{

        Solution solution = new Solution();
        solution.transferFileContent("C:/Users/cdadmin/Desktop/fromFile2.txt","C:/Users/cdadmin/Desktop/toFile2.txt");
        solution.transferFileContent("C:/Users/cdadmin/Desktop/emptyFromFile1.txt","C:/Users/cdadmin/Desktop/toFile1.txt");
        solution.transferFileContent("C:/Users/cdadmin/Desktop/fromFile1.txt","C:/Users/cdadmin/Desktop/emptyToFile1.txt");
    }
}
