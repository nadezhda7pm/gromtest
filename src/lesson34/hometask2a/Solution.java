package lesson34.hometask2a;

import java.io.*;
import java.util.regex.Pattern;

public class Solution {

    public void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
//        - validate the files;
//        - read the file content and return the text
//        - split the file content into two StringBuffers:
//           if the text does not contain the word - return null
//           if file name == fileTo, return the StringBuffer of sentences with the word
//           if file name == fileFrom, return the StringBuffer of sentences without the word
//        - write the text to the toFile
//        - if the text is successfully written, rewrite the text in the From file

        validateFiles(fileFromPath, fileToPath);
        StringBuffer fileFromContent = readFromFile(fileFromPath);

        try {
            writeToFile(fileToPath, textToWrite(fileFromContent, word, "fileToPath"));
            writeToFile(fileFromPath, textToWrite(fileFromContent, word, "fileFromPath"));
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
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
            }

        } catch (FileNotFoundException e) {
            System.err.println("File " + path + " does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + "failed");
        }
        return res;
    }


    private StringBuffer textToWrite(StringBuffer text, String word, String fileType) throws Exception {
        StringBuffer textForFileTo = new StringBuffer();
        StringBuffer textForFileFrom = new StringBuffer();

        String[] tempStrings = text.toString().split(Pattern.quote("."));

        for (int i = 0; i < tempStrings.length; i++) {
            if ((tempStrings[i].length() > 10) && containsWord(tempStrings[i], word)) {
                textForFileTo.append(tempStrings[i]);
                textForFileTo.append(".");
            } else {
                textForFileFrom.append(tempStrings[i]);
                textForFileFrom.append(".");
            }
        }
        if (textForFileTo.length() == 0) {
            return null;
        } else if (fileType.equals("fileToPath")) {
            return textForFileTo;
        } else return textForFileFrom;
    }


    private boolean containsWord(String string, String word) {
        boolean result = false;
        String[] words = string.split(" ");
        for (String w : words) {
            if (w.equals(word)) {
                result = true;
            }
        }
        return result;
    }


    private void writeToFile(String path, StringBuffer content) throws Exception {

        if (content == null){
            throw new Exception("There's nothing to write!");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, false))) {
            bufferedWriter.append(content);
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
