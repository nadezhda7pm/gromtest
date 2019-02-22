package lesson19.hometask;


public class Controller {

    public static File put(Storage storage, File file) throws Exception {
        // if file or storage is null+
        if (storage == null || file == null)
            try {
                throw new Exception();
            } catch (Exception e) {
                if (storage == null) System.out.println("Storage is null");
                if (file == null) System.out.println("File is null");
                return null;
            }

        // if file format is wrong
        validateFileFormat(storage, file);
        // if storage size is not enough for the putting file
        validateStorageSizeForFile(storage, file);
        // if file exists in the storage
        filePresent(storage, file.getId());

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                return storage.getFiles()[i];
            }
        }
        return null;
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
                System.out.println("ALL: File with id " + storageFrom.getFiles()[i].getId() + "was not transferred to " + storageTo.getId() + " Reason: " + e.getMessage());
            }
        }

    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {

        // if there is no file with such id to transfer
        filePresent(storageFrom, id);

        //StorageTo actual size is not enough for transfer
        validateStorageSizeForStorage(storageFrom, storageTo, id);

        for (int i = 0; i < storageTo.getFiles().length; i++) {
            try {
                put(storageTo, getFileById(storageFrom, id));
                return;
            } catch (Exception e) {
                System.out.println("FILE: File with id " + id + " was not transferred to storage" + storageTo.getId() + " Reason: " + e.getMessage() + " Reason: " + e.getMessage());
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
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat()))
                return;
        }
        throw new Exception("File " + file.getId() + " format is not acceptable");
    }

    private static void validateStorageForNULL(Storage storage) throws Exception {
        if (storage == null) throw new Exception("Storage is null");
    }

    private static void validateStorageToFilesArrayLength(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom.getFiles().length > storageTo.getFiles().length)
            throw new ArrayIndexOutOfBoundsException("FilesArray length in storageTo is not enough for transfer");
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

    private static void filePresent(Storage storage, long id) throws Exception {

        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == id)
                throw new Exception("File with id " + id + " already exists in the storage");
        }
    }
}
