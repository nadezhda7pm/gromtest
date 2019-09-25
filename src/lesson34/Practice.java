package lesson34;


import java.io.*;

public class Practice {

    public static void main(String[] args) throws Exception {
        copyFileContent("C:/Users/cdadmin/Desktop/testFrom.txt", "C:/Users/cdadmin/Desktop/testTo.txt");

    }

    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        //check if fileFrom and fileTo exist
        // read content from fileFrom
        // write content to fileTo

        validate(fileFromPath, fileToPath);
        writeToFile(fileToPath, readFromFile(fileFromPath));
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }

            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + "failed");
        }
        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file " + path);
        }
    }


    private static void validate(String fileFromPath, String fileToPath) throws Exception {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + "does not have permissions to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + "does not have permissions to be written");
        }
    }

}
