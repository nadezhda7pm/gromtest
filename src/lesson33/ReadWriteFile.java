package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public static void main(String[] args) throws InterruptedException{

//        readFile("C:/Users/cdadmin/Desktop/test.txt");
//        writeFile("C:/Users/cdadmin/Desktop/testAAAAA.txt", "text text text ");
//        writeFile("C:/Users/cdadmin/Desktop/testWWWWWWWW.odt", "new text! \n new text!!!!!");

//        writeToFileFromConsole("C:/Users/cdadmin/Desktop/testDDD.odt");

        readFileByConsolePath();


    }

    private static void readFile(String path) {

        FileReader reader;

        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Can't read file by path" + path);
        }finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }



    private static void writeFile (String path, String content) throws InterruptedException{

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            //TODO use other constructor
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append(content);
            bufferedWriter.append("\n");

        } catch (IOException e) {
            System.err.println("Can't write to file" + path);
            return;
        }finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }


    private static void writeToFileFromConsole(String path){

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        String content = "";
        FileReader fileReader;

        System.out.println("Enter file content to write in the file: ");

        try {
            String line;
            while(!(line = br.readLine()).equals("wr")) {
                    content += line;

            }
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }finally {
        IOUtils.closeQuietly(reader);
        IOUtils.closeQuietly(br);
    }

        try {
            fileReader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append(content);

        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        }finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }


    private static void readFileByConsolePath(){

        System.out.println("Please, enter file path to read: ");

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String path = null;


        try {
            path = br.readLine();
        } catch (IOException e) {
            System.err.println("Reading from keyboard failed");
        }finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }

        readFile(path);

    }







}
