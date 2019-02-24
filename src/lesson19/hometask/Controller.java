package lesson19.hometask;


public class Controller {

    public static File put(Storage storage, File file) throws Exception {
        validateFileFormat(storage, file);
        filePresent(storage, file.getId());
        validateStorageSize(storage, file);

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
        validateStorageSize(storageFrom, storageTo);
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if (put(storageTo, storageFrom.getFiles()[i]) == null)
                throw new Exception("ALL: File with id " + storageFrom.getFiles()[i].getId() + "was not transferred to " + storageTo.getId());
        }
    }


    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        filePresent(storageFrom, id);
        validateStorageSize(storageTo, getFileById(storageFrom, id));
        for (int i = 0; i < storageTo.getFiles().length; i++) {
            if (put(storageTo, getFileById(storageFrom, id)) == null)
                throw new Exception("FILE: File with id " + id + " was not transferred to storage" + storageTo.getId());
        }
    }


//    Validation___________________________________________________

    private static void validateStorageSize(Storage storage, File file) throws Exception {
        validateAvailableCellsInStorageFilesArray(storage);
        if (getStorageActualSize(storage) + file.getSize() > storage.getStorageSize())
            throw new Exception("Storage " + storage.getId() + " size is not enough for the putting file " + file.getId());
    }

    private static void validateStorageSize(Storage storageFrom, Storage storageTo) throws Exception {
        validateAvailableCellsInStorageFilesArray(storageFrom, storageTo);
        if (getStorageActualSize(storageFrom) > storageTo.getStorageSize() - getStorageActualSize(storageTo))
            throw new Exception("Storage " + storageTo.getId() + " size is not enough for transfer");
    }

    private static void validateFileFormat(Storage storage, File file) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat()))
                return;
        }
        throw new Exception("File " + file.getId() + " format is not acceptable");
    }

    private static void validateAvailableCellsInStorageFilesArray(Storage storageFrom, Storage storageTo) throws Exception {
        int c = 0;
        for (File f : storageFrom.getFiles()) {
            if (f != null)
                c++;
        }

        int n = 0;
        for (File f : storageTo.getFiles()) {
            if (f == null)
                n++;
        }

        if (c > n)
            throw new ArrayIndexOutOfBoundsException("FilesArray length in storageTo  " + storageTo.getId() + " is not enough for transfer");
    }

    private static void validateAvailableCellsInStorageFilesArray(Storage storage) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null)
                return;
        }
        throw new ArrayIndexOutOfBoundsException("FilesArray length in storage " + storage.getId() + " is not enough for transfer");
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

    public static void filePresent(Storage storage, long id) throws Exception {
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == id)
                throw new Exception("File with id " + id + " already exists in the storage" + storage.getId());
        }
    }
}
