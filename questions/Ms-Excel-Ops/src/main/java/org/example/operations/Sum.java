package org.example.operations;

import org.example.entity.Tab;
import org.example.service.IndexService;
import org.example.service.SheetManager;

public class Sum implements OperationStrategy {
    private final IndexService indexService;

    public Sum(IndexService indexService) {
        this.indexService = indexService;
    }

    @Override
    public Object execute(Object... parameters) {
        Tab tab = (Tab) parameters[0];
        String expression = (String) parameters[1];
        String[] parts = expression.split(":");
        int[] sumSt = indexService.getIndexFrom(parts[0]);
        int[] sumEn = indexService.getIndexFrom(parts[1]);
        int sum = 0;
        for (int i = sumSt[0]; i <= sumEn[0]; i++) {
            for (int j = sumSt[1]; j <= sumEn[1]; j++) {
                if (tab.getData()[i][j] != null && !tab.getData()[i][j].isFunction() && tab.getData()[i][j].getValue() instanceof Integer) {
                    sum += (int) tab.getData()[i][j].getValue();
                }
            }
        }
        return sum;
    }
}
