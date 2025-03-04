package org.example.entity;

public class Tab {
    private String tabName;
    private int totalRows;
    private int totalCols;
    private Cell[][] data;

    public Tab(String tabName, int rows, int cols) {
        this.tabName = tabName;
        this.totalRows = rows;
        this.totalCols = cols;
        this.data = new Cell[rows][cols];
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalCols() {
        return totalCols;
    }

    public Cell[][] getData() {
        return data;
    }
}
