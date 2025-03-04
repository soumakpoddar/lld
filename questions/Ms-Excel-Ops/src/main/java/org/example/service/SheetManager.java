package org.example.service;

import org.example.entity.Cell;
import org.example.entity.Tab;

public class SheetManager {
    private final FunctionServiceFactory functionServiceFactory;

    public SheetManager(FunctionServiceFactory functionServiceFactory) {
        this.functionServiceFactory = functionServiceFactory;
    }

    public void insertData(Tab tab, Object data, int row, int col) {
        if (tab.getTotalRows() < row || tab.getTotalCols() < col) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        tab.getData()[row][col] = new Cell(data);
    }

    public void printData(Tab tab, int row, int col) {
        if (tab.getTotalRows() < row || tab.getTotalCols() < col) {
            throw new IllegalArgumentException("Invalid row or column index");
        }
        if (tab.getData()[row][col] == null) {
            System.out.println("Empty");
        } else if (tab.getData()[row][col].isFunction()) {
            String value = tab.getData()[row][col].getValue().toString();
            String params = value.substring(value.indexOf("(") + 1, value.indexOf(")"));
            System.out.println(functionServiceFactory.getFunctionFromCell(tab.getData()[row][col]).execute(tab, params));
        } else {
            System.out.println(tab.getData()[row][col].getValue());
        }
    }
}
