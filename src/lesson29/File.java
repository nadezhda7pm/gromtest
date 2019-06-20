package lesson29;

import java.util.Objects;

public class File implements Comparable <File>{
    private String name;
    private long sizeInBytes;

    public File(String name, long sizeInBytes) {
        this.name = name;
        this.sizeInBytes = sizeInBytes;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", sizeInBytes=" + sizeInBytes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof File)) return false;
        File file = (File) o;
        return Objects.equals(name, file.name);
    }

    @Override
    public int compareTo(File file) {
        int res = 0;
        if (file.getSizeInBytes() > this.sizeInBytes)
            res = 1;
        else if (file.getSizeInBytes() < this.sizeInBytes)
            res = -1;
        return res;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
