package org.example;

public class Expression implements ArithmeticExpression {
    private final ArithmeticExpression left;
    private final ArithmeticExpression right;
    private final Operator operator;

    public Expression(ArithmeticExpression left, ArithmeticExpression right, Operator operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public int evaluate() {
        switch (operator) {
            case ADD:
                return left.evaluate() + right.evaluate();
            case SUBTRACT:
                return left.evaluate() - right.evaluate();
            case MULTIPLY:
                return left.evaluate() * right.evaluate();
            case DIVIDE:
                return left.evaluate() / right.evaluate();
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
