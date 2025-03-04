package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Sheet {
    private List<Tab> sheetTabs;
    private String sheetName;

    public Sheet(String sheetName) {
        this.sheetName = sheetName;
        this.sheetTabs = new ArrayList<>();
    }

    public void addTab(Tab tab) {
        sheetTabs.add(tab);
    }
}
