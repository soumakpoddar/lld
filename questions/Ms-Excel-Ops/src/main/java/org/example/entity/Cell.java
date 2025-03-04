package org.example.entity;

public class Cell {
    private Object value;

    public Cell(Object value) {
        this.value = value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public boolean isFunction() {
        return value instanceof String && ((String) value).startsWith("=");
    }
}
