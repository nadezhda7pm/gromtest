package lesson19.hometask;

import static lesson19.hometask.Validator.*;

public class Controller {

    public static void put(Storage storage, File file) throws Exception {

        // if storage or file is null
        validateFileForNULL(file);
        validateStorageForNULL(storage);

        // if file format is wrong
        validateFileFormat(storage, file);

        // if storage size is not enough for the putting file
        validateStorageSizeForFile(storage, file);

        // if file exists in the storage
        validateFilePresent (storage, file);

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

}
