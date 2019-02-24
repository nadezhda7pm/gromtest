package lesson19.hometask;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        File file = null;
        try {
            file = new File(0, "12345678901", "pdf", 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File fileF = null;
        try {
            fileF = new File(111, "nameF", "doc", 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File file1 = null;
        try {
            file1 = new File(1, "name1", "pdf", 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File file2 = null;
        try {
            file2 = new File(1, "name2", "pdf", 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File file3 = null;
        try {
            file3 = new File(3, "name3", "pdf", 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File file4 = null;
        try {
            file4 = new File(4, "name4", "pdf", 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File file5 = null;
        try {
            file5 = new File(5, "name5", "txt", 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File file6 = null;
        try {
            file6 = new File(6, "name6", "jpg", 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File file7 = null;
        try {
            file7 = new File(7, "name7", "pdf", 200);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        File file8 = null;
        try {
            file8 = new File(8, "name7", "pdf", 50);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        File[] filesX = new File[5];
        String[] formatsSupported = {"pdf", "txt", "jpg"};
        File[] files = {file, fileF, file1, file2, file3, null, file4, file5, file6, file7};
        File[] filesA = {file5, file4, null, file3, file1};
        File[] filesB = {file1, file3, file5, file6, file7};


        System.out.println(file);
        System.out.println(file1);
        System.out.println(Arrays.toString(filesX));
        System.out.println("_______________________________________");


        Storage storage = new Storage(0, filesX, formatsSupported ,"UK", 10);
        Storage storage1 = new Storage(1, filesX, formatsSupported ,"UK", 1000);
        Storage storage2 = new Storage(2, filesX, formatsSupported ,"UK", 300);
        Storage storage3 = new Storage(3, filesX, formatsSupported ,"UK", 1000);
        Storage storage4 = new Storage(4, filesX, formatsSupported ,"UK", 500);
        Storage storage5 = new Storage(5, filesX, formatsSupported ,"UK", 1000);
        Controller controller = new Controller();
        Controller controller2 = new Controller();




//        for (File f : filesA) {
//            try {
//                controller2.put(storage4, f);
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        System.out.println("storage4" + Arrays.deepToString(storage4.getFiles()));


        for (File f : files) {
            try {
                System.out.println(controller.put(storage1, f));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("storage1" + Arrays.deepToString(storage1.getFiles()));

        try {
            controller.put(storage1, file5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            controller.filePresent(storage1,4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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

        try {
            controller.transferAll(storage1, storage3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage3" + Arrays.toString(storage3.getFiles()));

        try {
            controller.transferAll(storage1, storage2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage2" + Arrays.toString(storage2.getFiles()));


        System.out.println("TRANSFER FILE_______________________________________");

        try {
            controller.transferFile(storage1, storage5, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        try {
            controller.transferFile(storage2, storage5, 3);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        try {
            controller.transferFile(storage1, storage5, 1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        try {
            controller.transferFile(storage1, storage5, 10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));


        try {
            controller.transferFile(storage1, storage5, 4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        try {
            controller.transferFile(storage1, storage5, 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        try {

            controller.transferFile(storage1, storage5, 7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));

        try {
            controller.transferFile(storage2, storage5, 8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage5" + Arrays.toString(storage5.getFiles()));


        Storage storage6 = new Storage(6, filesA, formatsSupported, "UA", 3000);
        Storage storage7 = new Storage(7, filesX, formatsSupported, "SK", 3000);

        Storage storage8 = null;
        Storage storage9 = null;

        try {
            controller.transferAll(storage7, storage6);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage6" + Arrays.toString(storage6.getFiles()));

        try {
            controller.transferAll(storage6, storage7);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("storage7" + Arrays.toString(storage7.getFiles()));
    }

}
