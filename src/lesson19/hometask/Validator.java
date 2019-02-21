package lesson19.hometask;


public class Validator {
    public static void validateStorageSizeForFile(Storage storage, File file) throws Exception {
        if (getStorageActualSize(storage) + file.getSize() > storage.getStorageSize())
            throw new Exception("Storage " + storage.getId() + " size is not enough for the putting file " + file.getId());
    }

    public static void validateStorageFromToSize(Storage storageFrom, Storage storageTo) throws Exception {
        if (getStorageActualSize(storageFrom) > storageTo.getStorageSize())
            throw new Exception("Storage " + storageTo.getId() + " size is not enough for transfer");
    }

    public static void validateStorageSizeForStorage(Storage storageFrom, Storage storageTo, long id) throws Exception {
        if ((getStorageActualSize(storageTo) + getFileById(storageFrom, id).getSize()) > storageTo.getStorageSize())
            throw new Exception("Storage " + storageTo.getId() + " size is not enough for transferring file " + id);
    }

    public static void validateFileFormat(Storage storage, File file) throws Exception {
        int c = 0;
        for (String format : storage.getFormatsSupported()) {
            if (file.getFormat().equals(format))
                c++;
        }
        if (c < 1) throw new Exception("File " + file.getId() + " format is not acceptable");
    }

    public static void validateFilePresent(Storage storage, File file) throws Exception {
        if (filePresent(storage, file))
            throw new Exception("File with id " + file.getId() + " already exists in the storage");
    }

    public static void validateFileForNULL(File file) throws Exception {
        if (file == null) throw new Exception("File is null");
    }

    public static void validateStorageForNULL(Storage storage) throws Exception {
        if (storage == null) throw new Exception("Storage is null");
    }

    public static void validateStorageToFilesArrayLength(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom.getFiles().length > storageTo.getFiles().length)
            throw new ArrayIndexOutOfBoundsException("FilesArray length in storageTo is not enough for transfer");
    }

    public static void validateFilePresentInStorageFrom(Storage storageFrom, long id) throws Exception {
        if (getFileById(storageFrom, id) == null)
            throw new Exception("File with id " + id + " not found in storage " + storageFrom.getId() + " Reason: " );
    }




    public static File getFileById(Storage storage, long id) {
        File foundFile = null;
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == id)
                foundFile = f;
        }
        return foundFile;
    }

    private static long getStorageActualSize(Storage storage) {
        long storageActualSize = 0;
        for (File f : storage.getFiles()) {
            if (f != null)
                storageActualSize += f.getSize();
        }
        return storageActualSize;
    }

    private static boolean filePresent(Storage storage, File file) {
        boolean filePresent = false;
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == file.getId())
                filePresent = true;
        }
        return filePresent;
    }


}




