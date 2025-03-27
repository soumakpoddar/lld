package org.example;

import org.example.entity.Collection;
import org.example.entity.File;
import org.example.service.ProcessManager;

import java.util.List;

// Question -
//Given a list of [FileName, FileSize, [Collection]] - Collection is optional, i.e., a collection can have 1 or more files. Same file can be a part of more than 1 collection.
//        How would you design a system
//
//        To calculate total size of files processed.
//        To calculate Top K collections based on size.
//        Example:
//        file1.txt(size: 100)
//file2.txt(size: 200) in collection "collection1"
//        file3.txt(size: 200) in collection "collection1"
//        file4.txt(size: 300) in collection "collection2"
//        file5.txt(size: 100)
//        Output:
//
//        Total size of files processed: 900
//        Top 2 collections:
//        - collection1 : 400
//        - collection2 : 300

public class Main {
    public static void main(String[] args) {
        ProcessManager processManager = new ProcessManager();
        Collection collection1 = new Collection("collection1");
        Collection collection2 = new Collection("collection2");
        Collection collection3 = new Collection("collection3");
        processManager.processFile(new File("file1", null, 100), null);
        processManager.processFile(new File("file2", null, 200), List.of(collection1));
        processManager.processFile(new File("file3", null, 200), List.of(collection1));
        processManager.processFile(new File("file4", null, 300), List.of(collection2));
        processManager.processFile(new File("file5", null, 1000), List.of(collection3));

        System.out.println("Total files size in bytes processed: " + processManager.getTotalFilesSizeInBytesProcessed());
        System.out.println("Top 2 collections: " + processManager.getTopNCollections(2));
    }
}