package lesson19.hometask;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        File file = new File(0, "12345678901", "pdf", 200);
        File fileF = new File(111, "nameF", "doc", 200);
        File file1 = new File(1, "name1", "pdf", 200);
        File file2 = new File(1, "name2", "pdf", 200);
        File file3 = new File(3, "name3", "pdf", 200);
        File file4 = new File(4, "name4", "pdf", 200);
        File file5 = new File(5, "name5", "txt", 200);
        File file6 = new File(6, "name6", "jpg", 200);
        File file7 = new File(7, "name7", "pdf", 200);
        File file8 = new File(8, "name7", "pdf", 50);

        File[] files = {file, fileF, file1, file2, file3, null, file4, file5, file6, file7};

        System.out.println(file);
        System.out.println(file1);
        System.out.println("_______________________________________");

        Storage storage = new Storage(0, "UK", 10);
        Storage storage1 = new Storage(1, "UK", 1000);
        Storage storage2 = new Storage(2, "UK", 900);
        Storage storage3 = new Storage(3, "UK", 1000);
        Storage storage4 = new Storage(4, "UK", 1000);
        Storage storage5 = new Storage(5, "UK", 1000);
        Controller controller = new Controller();


        for (File f : files) {
            try {
                controller.put(storage1, f);
            } catch (Exception e) {
                System.out.println("File with id " + f.getId() + "was not transferred!");
            }
        }
        System.out.println(Arrays.deepToString(storage1.getFiles()));

        for (File f : files) {
            try {
                controller.put(storage2, f);
            } catch (Exception e) {
                System.out.println("File with id " + f.getId() + "was not transferred!");
            }
        }
        System.out.println(Arrays.deepToString(storage2.getFiles()));
        System.out.println("_______________________________________");




        controller.delete(storage1, file6);
        System.out.println(Arrays.deepToString(storage1.getFiles()));

        controller.delete(storage2, file6);
        System.out.println(Arrays.deepToString(storage2.getFiles()));
        System.out.println("_______________________________________");


        try {
            controller.put(storage1, file7);
        } catch (Exception e) {
            System.out.println("File with id " + file7.getId() + "was not transferred!");
        }
        try {
            controller.put(storage2, file8);
        } catch (Exception e) {
            System.out.println("File with id " + file7.getId() + "was not transferred!");
        }

        controller.transferAll(storage1, storage3);
        System.out.println("storage3" + Arrays.toString(storage3.getFiles()));

        controller.transferAll(storage1, storage2);
        System.out.println("storage2" + Arrays.toString(storage2.getFiles()));


        System.out.println("TRANSFER FILE_______________________________________");

        controller.transferFile(storage1, storage5, 3);
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        controller.transferFile(storage2, storage5, 3);
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        controller.transferFile(storage1, storage5, 1);
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        controller.transferFile(storage1, storage5, 10);
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));


        controller.transferFile(storage1, storage5, 4);
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        controller.transferFile(storage1, storage5, 5);
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        controller.transferFile(storage1, storage5, 7);
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        controller.transferFile(storage2, storage5, 8);
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));




    }

}
