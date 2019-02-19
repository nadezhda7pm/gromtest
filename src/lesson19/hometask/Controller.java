package lesson19.hometask;

public class Controller {


    public static void put(Storage storage, File file) throws Exception {
        // if storage or file is null
        if (storage == null || file == null)
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                if (storage == null) System.err.println("Storage is null");
                if (file == null) System.err.println("File is null");
                return;
            }

        // if file format is wrong
        int c = 0;
        for (String format : storage.getFormatsSupported()) {
            if (file.getFormat().equals(format))
                c++;
        }
        if (c < 1) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("File " + file.getId() + " format is not acceptable");
                return;
            }
        }

        // if storage size is not enough for the putting file
        if (getStorageActualSize(storage) + file.getSize() > storage.getStorageSize()) try {
            throw new Exception();
        } catch (Exception e) {
            System.err.println("Storage " + storage.getId() + " size is not enough for the putting file " + file.getId());
            return;
        }


        // if file exists in the storage
        try {
            if (filePresent(storage, file)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("File with id " + file.getId() + " already exists in the storage");
            return;
        }
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

    public static void transferAll(Storage storageFrom, Storage storageTo) {
        // if storageFrom or storageTo is null
        if (storageFrom == null || storageTo == null)
            try {
                throw new NullPointerException();
            } catch (NullPointerException e) {
                if (storageFrom == null) System.err.println("StorageFrom is null");
                if (storageTo == null) System.err.println("StorageTo is null");
                return;
            }


        //StorageTo size is not enough for transfer
        try {
            if (getStorageActualSize(storageFrom) > storageTo.getStorageSize())
                throw new Exception();
        } catch (Exception e) {
            System.err.println("Storage " + storageTo.getId() + " size is not enough for transfer");
            return;
        }

        //FilesArray length in storageTo is not enough for transfer
        try {
            if (storageFrom.getFiles().length > storageTo.getFiles().length)
                throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e.getMessage());
            return;
        }

        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            try {
                put(storageTo, storageFrom.getFiles()[i]);
                return;
            } catch (Exception e) {
                System.err.println("File with id " + storageFrom.getFiles()[i].getId() + "was not transferred!");
            }
        }

    }

    public static void transferFile(Storage storageFrom, Storage storageTo, long id) {

        // if there is no file with such id to transfer
        try {
            if (getFileById(storageFrom, id) == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("File with id " + id + " not found in storage " + storageFrom.getId());
            return;
        }

        //StorageTo actual size is not enough for transfer
        try {
            if ((getStorageActualSize(storageTo) + getFileById(storageFrom, id).getSize()) > storageTo.getStorageSize()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.err.println("Storage " + storageTo.getId() + " size is not enough for transferring file " + id);
            return;
        }

        for (int i = 0; i < storageTo.getFiles().length; i++) {
            try {
                put(storageTo, getFileById(storageFrom, id));
                return;
            } catch (Exception e) {
                System.err.println("File with id " + id + " was not transferred to " + storageFrom.getId());
            }
        }

    }


    protected static long getStorageActualSize(Storage storage) {
        long storageActualSize = 0;
        for (File f : storage.getFiles()) {
            if (f != null)
                storageActualSize += f.getSize();
        }
        return storageActualSize;
    }

    protected static boolean filePresent(Storage storage, File file) throws Exception {
        boolean filePresent = false;
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == file.getId())
                filePresent = true;
        }
        return filePresent;
    }


    protected static File getFileById(Storage storage, long id) throws Exception {
        File foundFile = null;
        for (File f : storage.getFiles()) {
            if (f != null && f.getId() == id)
                foundFile = f;
        }
        return foundFile;
    }

}
