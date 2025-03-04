package org.example;

import org.example.entity.Sheet;
import org.example.entity.Tab;
import org.example.service.FunctionServiceFactory;
import org.example.service.IndexService;
import org.example.service.SheetManager;

public class Main {
    public static void main(String[] args) {
        Sheet sheet = new Sheet("Sheet1");
        Tab sampleOne = new Tab(
                "ColSum",
                1000,
                1000
        );
        sheet.addTab(sampleOne);
        IndexService indexService = new IndexService();
        FunctionServiceFactory functionServiceFactory = new FunctionServiceFactory(indexService);
        SheetManager sheetManager = new SheetManager(functionServiceFactory);
        sheetManager.insertData(sampleOne, 1, 0, 0);
        sheetManager.insertData(sampleOne, 2, 1, 0);
        sheetManager.insertData(sampleOne, 3, 2, 0);
        sheetManager.insertData(sampleOne, "=SUM(A1:A3)", 3, 0);
        sheetManager.printData(sampleOne, 0, 0);
        sheetManager.printData(sampleOne, 3, 0);
    }
}