package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {

    public static void main(String[] args) throws InterruptedException{

        readFile("C:/Users/cdadmin/Desktop/test.txt");
        writeFile("C:/Users/cdadmin/Desktop/testXXX.txt", "text text text ");
        writeFile("C:/Users/cdadmin/Desktop/testWWWWWWWW.odt", "new text! \n new text!!!!!");

    }

    private static void readFile(String path) {

        FileReader reader;

        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
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
            bufferedWriter.append(content);

        } catch (IOException e) {
            System.err.println("Can't write to file");
            return;
        }finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }

    }


}
