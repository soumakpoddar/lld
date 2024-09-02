package org.example;

public class Number implements ArithmeticExpression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
}
