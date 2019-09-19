package lesson34;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public static void main(String[] args) throws InterruptedException {

//        readFile("C:/Users/cdadmin/Desktop/test.txt");
//        writeFile("C:/Users/cdadmin/Desktop/testAAAAA.txt", "text text text ");
//        writeFile("C:/Users/cdadmin/Desktop/testWWWWWWWW.odt", "new text! \n new text!!!!!");

//        writeToFileFromConsole("C:/Users/cdadmin/Desktop/testDDD.odt");

        readFileByConsolePath();


    }

    private static void readFile(String path) {

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
        } catch (IOException e) {
            System.err.println("Can't read file by path" + path);

        }
    }


    private static void writeFile(String path, String content) throws InterruptedException {
       try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
           //TODO use other constructor
           bufferedWriter.append(content);
           bufferedWriter.append("\n");
       } catch (IOException e) {
           System.err.println("Can't write to file" + path);
       }
    }


    private static void writeToFileFromConsole(String path){

        String content = "";
        FileReader fileReader;
        System.out.println("Enter file content to write in the file: ");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line;
            while(!(line = br.readLine()).equals("wr")) {
                content += line;
            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }

        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))){
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        }
    }


    private static void readFileByConsolePath(){

        System.out.println("Please, enter file path to read: ");
        String path = null;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            path = br.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }

        readFile(path);
    }

}
