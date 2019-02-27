package lesson19.hometask;


public class Controller {

    public static File put(Storage storage, File file) throws Exception {
        validate(storage, file);

        int i = 0;
        for ( File f : storage.getFiles()) {
            if (f == null) {
                storage.getFiles()[i] = file;
                break;
            }
            i++;
        }
        return storage.getFiles()[i];
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
        noFileToTransfer(storageFrom, id);
//        validateFilesArrayLength(storageTo, storageFrom.getFiles().length);
//        filePresent(storageTo, id);
//        validateFileFormat(storageTo, getFileById(storageFrom, id));

        put(storageTo, getFileById(storageFrom, id));
    }


//    Validation___________________________________________________

    private static void validate(Storage storage, File file) throws Exception {
        filePresent(storage, file.getId());
        validateFileFormat(storage, file);
        validateFilesArrayLength(storage);
        validateSize(storage, file);
    }

    private static boolean validateAll(Storage storageFrom, Storage storageTo) throws Exception {
        boolean validateAll = false;
        validateFilesArrayLength(storageTo, storageFrom.getFiles().length);

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            filePresent(storageTo, storageFrom.getFiles()[i].getId());
            validateFileFormat(storageTo, storageFrom.getFiles()[i]);
            validateSize(storageTo, storageFrom.getFiles()[i]);

            if (i == (storageFrom.getFiles().length - 1))
                validateAll = true;
        }
        return validateAll;
    }

    private static void validateSize (Storage storage, File file) throws Exception{
        long usedSize = 0;
        for (File f : storage.getFiles()){
            if (f != null)
                usedSize += f.getSize();
        }
        if (usedSize + file.getSize() > storage.getStorageSize())
            throw new Exception("Storage " + storage.getId() + " size is not enough for transfer");
    }

    private static void validateFilesArrayLength (Storage storage) throws Exception{
        for ( File file : storage.getFiles()){
            if (file == null)
                return;
        }
        throw new Exception("FilesArray length in storage" + storage.getId() + " is not enough for transfer");
    }

    private static void validateFilesArrayLength (Storage storage, int lengthRequired) throws Exception{
        int count = 0;
        for ( File file : storage.getFiles()){
            if (file == null)
                count++;
        }
        if (count < lengthRequired)
        throw new Exception("FilesArray length in storage" + storage.getId() + " is not enough for transfer");
    }

    private static void validateFileFormat(Storage storage, File file) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(file.getFormat()))
                return;
        }
        throw new Exception("File " + file.getId() + " format is not acceptable");
    }

    public static File getFileById(Storage storage, long id) throws Exception {

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == id)
            return  storage.getFiles()[i];
        }
        throw new Exception("File " + id + " not found");
    }

//    ----
    private static long getStorageActualSize(Storage storage) {
        long storageActualSize = 0;
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null)
                storageActualSize += storage.getFiles()[i].getSize();
        }
        return storageActualSize;
    }

    public static void filePresent(Storage storage, long id) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == id)
                throw new Exception("File with id " + id + " already exists in the storage" + storage.getId());
        }
    }

    public static void noFileToTransfer(Storage storageFrom, long id) throws Exception {
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if (storageFrom.getFiles()[i] != null && storageFrom.getFiles()[i].getId() == id)
                return;
        }throw new Exception("File with id " + id + " not found in the storage" + storageFrom.getId());
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





//    private static boolean validateAll(Storage storageFrom, Storage storageTo) throws Exception {
//        boolean validateAll = false;
//        int c = 0;
//        for (File f : storageFrom.getFiles()) {
//            if (f != null)
//                c++;
//        }
//
//        int n = 0;
//        for (File f : storageTo.getFiles()) {
//            if (f == null)
//                n++;
//        }
//
//        if (c > n)
//            throw new Exception("FilesArray length in storage" + storageTo.getId() + " is not enough for transfer");
//
//        for (int i = 0; i < storageFrom.getFiles().length; i++) {
//            validateFileFormat(storageTo, storageFrom.getFiles()[i]);
//            filePresent(storageTo, storageFrom.getFiles()[i]);
//            if (i == (storageFrom.getFiles().length - 1))
//                validateAll = true;
//        }
//        return validateAll;
//    }



//
//    public static File put(Storage storage, File file) throws Exception {
//        validateAll(storage, file);
//
//        for (int i = 0; i < storage.getFiles().length; i++) {
//            if (storage.getFiles()[i] == null) {
//                storage.getFiles()[i] = file;
//                return storage.getFiles()[i];
//            }
//        }
//        throw new Exception("File with id " + file.getId() + " was not transferred to storage" + storage.getId());
//    }