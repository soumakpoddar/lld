package org.example.entity;

public class File {
    private String fileName;
    private Object content;
    private long fileSizeInBytes;

    public File(String fileName, Object content, long fileSizeInBytes) {
        this.fileName = fileName;
        this.content = content;
        this.fileSizeInBytes = fileSizeInBytes;
    }

    public long getFileSizeInBytes() {
        return fileSizeInBytes;
    }
}
