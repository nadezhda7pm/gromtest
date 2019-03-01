package lesson19.hometask;


public class Controller {

    public static File put(Storage storage, File file) throws Exception {
        validate(storage, file);

        int i = 0;
        for (File f : storage.getFiles()) {
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


        validateAll(storageFrom, storageTo);

        for (File sFromFile : storageFrom.getFiles()) {
            if (sFromFile != null) {
                int i = 0;
                for (File sToFile : storageTo.getFiles()) {
                    if (sToFile == null) {
                        storageTo.getFiles()[i] = sFromFile;
                        break;
                    } else i++;

                }
            }
        }


    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        noFileToTransfer(storageFrom, id);
        put(storageTo, getFileById(storageFrom, id));
    }


//    Validation___________________________________________________

    private static void validate(Storage storage, File file) throws Exception {
        filePresent(storage, file.getId());
        validateFileFormat(storage, file.getFormat());
        validateFilesArrayLength(storage);
        validateSize(storage, file.getSize());
    }

    private static void validateAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (getStorageActualSize(storageFrom) > storageTo.getStorageSize() - getStorageActualSize(storageTo))
            throw new Exception("Storage " + storageTo.getId() + " size is not enough for transfer");
        validateFilesArrayLength(storageTo, storageFrom.getFiles().length);

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            filePresent(storageTo, storageFrom.getFiles()[i].getId());
            validateFileFormat(storageTo, storageFrom.getFiles()[i].getFormat());
        }
    }

    private static void validateSize(Storage storage, long fileSize) throws Exception {
        long usedSize = 0;
        for (File file : storage.getFiles()) {
            if (file != null)
                usedSize += file.getSize();
        }
        if (usedSize + fileSize > storage.getStorageSize())
            throw new Exception("Storage " + storage.getId() + " size is not enough for transfer");
    }

    private static void validateFilesArrayLength(Storage storage) throws Exception {
        for (File file : storage.getFiles()) {
            if (file == null)
                return;
        }
        throw new Exception("FilesArray length in storage" + storage.getId() + " is not enough for transfer");
    }

    private static void validateFilesArrayLength(Storage storage, int lengthRequired) throws Exception {
        int count = 0;
        for (File file : storage.getFiles()) {
            if (file == null)
                count++;
        }
        if (count < lengthRequired)
            throw new Exception("FilesArray length in storage" + storage.getId() + " is not enough for transfer");
    }

    private static void validateFileFormat(Storage storage, String fileFormat) throws Exception {
        for (String format : storage.getFormatsSupported()) {
            if (format.equals(fileFormat))
                return;
        }
        throw new Exception(fileFormat + " format is not supported in " + storage.getId());
    }

    public static void filePresent(Storage storage, long id) throws Exception {
        for (File file : storage.getFiles()) {
            if (file != null && file.getId() == id)
                throw new Exception("File with id " + id + " already exists in the storage" + storage.getId());
        }
    }

    public static File getFileById(Storage storage, long id) throws Exception {

        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == id)
                return storage.getFiles()[i];
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

    public static void noFileToTransfer(Storage storageFrom, long id) throws Exception {
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if (storageFrom.getFiles()[i] != null && storageFrom.getFiles()[i].getId() == id)
                return;
        }
        throw new Exception("File with id " + id + " not found in the storage" + storageFrom.getId());
    }

}
