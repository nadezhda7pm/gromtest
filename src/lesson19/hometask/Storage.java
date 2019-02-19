package lesson19.hometask;

import java.util.Arrays;

public class Storage {
    private long id;
    private File[] files = new File[5];
    private String[] formatsSupported ={"pdf", "jpg", "txt" };
    private String storageCountry;
    private long storageSize;


    public Storage(long id, String storageCountry, long storageSize) {
        this.id = id;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public long getStorageSize() {
        return storageSize;
    }
}
