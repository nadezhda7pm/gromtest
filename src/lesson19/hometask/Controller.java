package lesson19.hometask;

import static lesson19.hometask.Validator.*;

public class Controller {

    public static void put(Storage storage, File file) throws Exception {
        // if file or storage is null
        validateFileForNULL(file);
        validateStorageForNULL(storage);
        // if file exists in the storage
        validateFilePresent(storage, file);
        // if file format is wrong
        validateFileFormat(storage, file);
        // if storage size is not enough for the putting file
        validateStorageSizeForFile(storage, file);

            for (int i = 0; i < storage.getFiles().length; i++) {
                if (storage.getFiles()[i] == null) {
                    storage.getFiles()[i] = file;
                    return;
                }
            }
        }


    public static void delete(Storage storage, File file) {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].equals(file)) {
                storage.getFiles()[i] = null;
                return;
            }
        }
    }

    public static void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        // if storageFrom or storageTo is null
        validateStorageForNULL(storageFrom);
        validateStorageForNULL(storageTo);

        //StorageTo size is not enough for transfer
        validateStorageFromToSize(storageFrom, storageTo);

        //FilesArray length in storageTo is not enough for transfer
        validateStorageToFilesArrayLength(storageFrom, storageTo);

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            try {
                put(storageTo, storageFrom.getFiles()[i]);
            } catch (Exception e) {
                System.err.println("File with id " + storageFrom.getFiles()[i].getId() + "was not transferred to " + storageTo.getId()  + " Reason: " + e.getMessage());
            }
        }

    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        // if there is no file with such id to transfer
        validateFilePresentInStorageFrom(storageFrom, id);

        //StorageTo actual size is not enough for transfer
        validateStorageSizeForStorage(storageFrom, storageTo, id);

        for (int i = 0; i < storageTo.getFiles().length; i++) {
            try {
                put(storageTo, getFileById(storageFrom, id));
                return;
            } catch (Exception e) {
                System.err.println("File with id " + id + " was not transferred to " + storageTo.getId() + "Reason: " + e.getMessage() + " Reason: " + e.getMessage());
            }
        }
    }


//    Validation___________________________________________________
    
    private static void validateStorageSizeForFile(Storage storage, File file) throws Exception {
        if (getStorageActualSize(storage) + file.getSize() > storage.getStorageSize())
            throw new Exception("Storage " + storage.getId() + " size is not enough for the putting file " + file.getId());
    }

    private static void validateStorageFromToSize(Storage storageFrom, Storage storageTo) throws Exception {
        if (getStorageActualSize(storageFrom) > storageTo.getStorageSize())
            throw new Exception("Storage " + storageTo.getId() + " size is not enough for transfer");
    }

    private static void validateStorageSizeForStorage(Storage storageFrom, Storage storageTo, long id) throws Exception {
        if ((getStorageActualSize(storageTo) + getFileById(storageFrom, id).getSize()) > storageTo.getStorageSize())
            throw new Exception("Storage " + storageTo.getId() + " size is not enough for transferring file " + id);
    }

    private static void validateFileFormat(Storage storage, File file) throws Exception {
        int c = 0;
        for (String format : storage.getFormatsSupported()) {
            if (file.getFormat().equals(format))
                c++;
        }
        if (c < 1) throw new Exception("File " + file.getId() + " format is not acceptable");
    }

    private static void validateFilePresent(Storage storage, File file) throws Exception {
        if (filePresent(storage, file))
            throw new Exception("File with id " + file.getId() + " already exists in the storage");
    }

    private static void validateFileForNULL(File file) throws Exception {
        if (file == null) throw new Exception("File is null");
    }

    private static void validateStorageForNULL(Storage storage) throws Exception {
        if (storage == null) throw new Exception("Storage is null");
    }

    private static void validateStorageToFilesArrayLength(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom.getFiles().length > storageTo.getFiles().length)
            throw new ArrayIndexOutOfBoundsException("FilesArray length in storageTo is not enough for transfer");
    }

    private static void validateFilePresentInStorageFrom(Storage storageFrom, long id) throws Exception {
        if (getFileById(storageFrom, id) == null)
            throw new Exception("File with id " + id + " not found in storage " + storageFrom.getId() + " Reason: " );
    }




    private static File getFileById(Storage storage, long id) {
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
