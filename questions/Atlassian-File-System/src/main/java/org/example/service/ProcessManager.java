package org.example.service;

import org.example.entity.Collection;
import org.example.entity.File;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ProcessManager {
    private long totalFilesSizeInBytesProcessed;
    private PriorityQueue<Collection> topCollections;

    public ProcessManager() {
        totalFilesSizeInBytesProcessed = 0;
        topCollections = new PriorityQueue<>((a, b) -> (int) (b.getCollectionSizeInBytes() - a.getCollectionSizeInBytes()));
    }

    public long getTotalFilesSizeInBytesProcessed() {
        return totalFilesSizeInBytesProcessed;
    }

    public void processFile(File file, List<Collection> collections) {
        totalFilesSizeInBytesProcessed += file.getFileSizeInBytes();
        if (collections != null) {
            for (Collection collection : collections) {
                collection.addFileToCollection(file);
                topCollections.remove(collection);
                topCollections.add(collection);
            }
        }
    }

    public List<Collection> getTopNCollections(int n) {
        List<Collection> topNCollections = new ArrayList<>();
        while (n > 0 && !topCollections.isEmpty()) {
            topNCollections.add(topCollections.poll());
            n--;
        }
        for (Collection collection : topNCollections) {
            System.out.println(collection.getCollectionName() + " " + collection.getCollectionSizeInBytes());
            topCollections.add(collection);
        }
        return topNCollections;
    }
}
