package lesson34.hometask3;

import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {

    public void copyFileContent(String fileFromPath, String fileToPath) {

        try {
            Files.copy(Paths.get(fileFromPath), new FileOutputStream(fileToPath));
        } catch (IOException e) {
            System.err.println("File could not be copied.");
        }

    }


    public void copyFileContentApacheIO(String fileFromPath, String fileToPath) {


        File src = new File(fileFromPath);
        File target = new File(fileToPath);

        try {
            FileUtils.copyFile(src, target);
        } catch (IOException e) {
            System.err.println("File could not be copied.");
        }

    }

}
