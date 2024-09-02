package org.example;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Directory implements FileSystem {
    private String name;
    private List<FileSystem> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystem fileSystem) {
        children.add(fileSystem);
    }

    @Override
    public void ls() {
        for (FileSystem fileSystem : children) {
            fileSystem.ls();
        }
    }
}
