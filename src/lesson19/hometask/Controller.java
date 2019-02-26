package lesson19.hometask;


public class Controller {

    public static File put(Storage storage, File file) throws Exception {
        validateFileFormat(storage, file);
        filePresent(storage, file);
        if (getStorageActualSize(storage) + file.getSize() > storage.getStorageSize())
            throw new Exception("Storage " + storage.getId() + " size is not enough for the putting file " + file.getId());

// I think the next verification is not necessary as we anyway will received the Exception while trying to add file
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null)
                break;
            if (storage.getFiles()[i] != null && i == (storage.getFiles().length - 1))
                throw new Exception("FilesArray length in storage " + storage.getId() + " is not enough for transferring file" + file.getId());
        }


        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                storage.getFiles()[i] = file;
                return storage.getFiles()[i];
            }
        }
        throw new Exception("File with id " + file.getId() + " was not transferred to storage" + storage.getId());
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
        if (getStorageActualSize(storageFrom) > storageTo.getStorageSize() - getStorageActualSize(storageTo))
            throw new Exception("Storage " + storageTo.getId() + " size is not enough for transfer");

        if (validateAll(storageFrom, storageTo)) {
            for (int i = 0; i < storageFrom.getFiles().length; i++) {
                put(storageTo, storageFrom.getFiles()[i]);
            }
        }
    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        fileNotPresent(storageFrom, id);
        //        do we really need the following verifications if the put method has the same?
        for (int i = 0; i < storageTo.getFiles().length; i++) {
            if (storageTo.getFiles()[i] == null)
                break;
            if (storageTo.getFiles()[i] != null && i == (storageTo.getFiles().length - 1))
                throw new Exception("FilesArray length in storage " + storageTo.getId() + " is not enough for transferring file" + id);
        }

        if (getStorageActualSize(storageTo) + getFileById(storageFrom, id).getSize() > storageTo.getStorageSize())
            throw new Exception("Storage " + storageTo.getId() + " size is not enough for the putting file " + id);

        filePresent(storageTo, getFileById(storageFrom, id));
        validateFileFormat(storageTo, getFileById(storageFrom, id));

        put(storageTo, getFileById(storageFrom, id));
    }


//    Validation___________________________________________________

    private static boolean validateAll(Storage storageFrom, Storage storageTo) throws Exception {
        boolean validateAll = false;
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
            throw new Exception("FilesArray length in storage" + storageTo.getId() + " is not enough for transfer");

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            validateFileFormat(storageTo, storageFrom.getFiles()[i]);
            filePresent(storageTo, storageFrom.getFiles()[i]);
            if (i == (storageFrom.getFiles().length - 1))
                validateAll = true;
        }
        return validateAll;
    }

    private static void validateFileFormat(Storage storage, File file) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat()))
                return;
        }
        throw new Exception("File " + file.getId() + " format is not acceptable");
    }

    public static File getFileById(Storage storage, long id) {
        File foundFile = null;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == id)
                foundFile = storage.getFiles()[i];
        }
        return foundFile;
    }

    private static long getStorageActualSize(Storage storage) {
        long storageActualSize = 0;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null)
                storageActualSize += storage.getFiles()[i].getSize();
        }
        return storageActualSize;
    }

    public static void filePresent(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == file.getId())
                throw new Exception("File with id " + file.getId() + " already exists in the storage" + storage.getId());
        }
    }

    public static void fileNotPresent(Storage storage, long id) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == id)
                return;
        }throw new Exception("File with id " + id + " not found in the storage" + storage.getId());
    }

}


//
//_________________________________________________________
//
//
//    private static void validateStorageSize(Storage storage, File file) throws Exception {
//        if (getStorageActualSize(storage) + file.getSize() > storage.getStorageSize())
//            throw new Exception("Storage " + storage.getId() + " size is not enough for the putting file " + file.getId());

//        for (int i = 0; i < storage.getFiles().length; i++) {
//            if (storage.getFiles()[i] == null)
//                break;
//            if (storage.getFiles()[i] != null && i == (storage.getFiles().length - 1))
//                throw new Exception("FilesArray length in storage " + storage.getId() + " is not enough for transferring file" + file.getId());
//        }
//
//    }
//
//    private static void validateStorageSize(Storage storageFrom, Storage storageTo) throws Exception {
//        if (getStorageActualSize(storageFrom) > storageTo.getStorageSize() - getStorageActualSize(storageTo))
//            throw new Exception("Storage " + storageTo.getId() + " size is not enough for transfer");

//        int c = 0;
//        for (File f : storageFrom.getFiles()) {
//            if (f != null)
//                c++;
//        }
//        int n = 0;
//        for (File f : storageTo.getFiles()) {
//            if (f == null)
//                n++;
//        }
//        if (c > n)
//            throw new Exception("FilesArray length in storage" + storageTo.getId() + " is not enough for transfer");
//    }
