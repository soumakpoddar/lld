package org.example.service;

import org.example.entity.Cell;
import org.example.enums.Function;
import org.example.operations.OperationStrategy;
import org.example.operations.Sum;

public class FunctionServiceFactory {
    private final IndexService indexService;

    public FunctionServiceFactory(IndexService indexService) {
        this.indexService = indexService;
    }

    public OperationStrategy getFunctionFromCell(Cell cell) {
        if (cell.isFunction()) {
            Function cellFunction = getFunction(cell.getValue().toString());
            switch (cellFunction) {
                case SUM:
                    return new Sum(indexService);
                default:
                    throw new IllegalArgumentException("Invalid function name");
            }
        } else {
            return null;
        }
    }

    private Function getFunction(String string) {
        String functionName = string.substring(1, string.indexOf("("));
        switch (functionName) {
            case "SUM":
                return Function.SUM;
            default:
                throw new IllegalArgumentException("Invalid function name");
        }
    }
}
