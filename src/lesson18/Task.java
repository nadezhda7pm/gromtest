package lesson18;

public class Task {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        String[] fileNames = {"test1", "test2"};
        fileStorage.setFiles(fileNames);

        FileStorage fileStorage2 = new FileStorage();
        String[] fileNames2 = {"2test1", "2test2", "2test3", "2test4", "2test5", "2test6"};
        fileStorage2.setFiles(fileNames2);

        FileStorage fileStorage3 = new FileStorage();
        String[] fileNames3 = {"3test1", "3test2", "3test3", null, null, "3test6"};
        fileStorage3.setFiles(fileNames3);

        System.out.println("Start printing name...");

        printer(fileStorage);
        printer(fileStorage2);
        printer(fileStorage3);

        printer2(fileStorage);
        printer2(fileStorage2);
        printer2(fileStorage3);

        System.out.println("Done");

    }

    public static void printer2(Storage storage) {
        String[] names = storage.getFiles();
        try {
            if (!names[4].isEmpty() && names[4] != null)
                System.out.println("5th name is " + names[4]);
        } catch(Exception e)

        {
            System.out.println("5th name can not be found ...");
        }
    }

    public static void printer(Storage storage) {
        String[] names = storage.getFiles();
        try {
            System.out.println("5th name is " + names[4]);
        } catch (Exception e) {
            System.out.println("5th name can not be found ...");
        }
    }

}
