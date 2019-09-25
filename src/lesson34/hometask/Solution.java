package lesson34.hometask;

import org.apache.commons.io.FileUtils;

import java.io.*;

public class Solution {

    public void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validateFiles(fileFromPath, fileToPath);
        try {
            writeToFile(fileToPath, readFromFile(fileFromPath));
        }catch (IOException e) {
            System.err.println("Can't write to file " + fileToPath);
            return;
        }
            deleteFileContent(fileFromPath);
    }


    private StringBuffer readFromFile(String path) throws Exception {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }

            if (res.length() > 0) {
                res.replace((res.length() - 1), res.length(), "");
            } else throw new Exception("File " + path + " is empty");

        } catch (FileNotFoundException e) {
            System.err.println("File " + path + " does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + "failed");
        }
        return res;
    }


    private void writeToFile(String path, StringBuffer content) throws Exception {

        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {

            if(file.length() > 0){
                bufferedWriter.append("\n");
                bufferedWriter.append(content);
            }else
                bufferedWriter.append(content);
        }
    }

    private void deleteFileContent(String path){

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append("");
        } catch (IOException e) {
            System.err.println("Content of file " + path + "cannot be deleted");
        }
    }



    private void validateFiles(String fileFromPath, String fileToPath) throws Exception {

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " does not exist");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " does not exist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permissions to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + "does not have permissions to be written");
        }
        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileFrom + "does not have permissions to be written");
        }


    }
}
