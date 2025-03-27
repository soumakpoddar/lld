package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    private List<File> files;
    private long collectionSizeInBytes;
    private String collectionName;

    public Collection(String collectionName) {
        this.collectionName = collectionName;
        files = new ArrayList<>();
        collectionSizeInBytes = 0;
    }

    public void addFileToCollection(File file) {
        files.add(file);
        collectionSizeInBytes += file.getFileSizeInBytes();
    }

    public long getCollectionSizeInBytes() {
        return collectionSizeInBytes;
    }

    public String getCollectionName() {
        return collectionName;
    }
}
