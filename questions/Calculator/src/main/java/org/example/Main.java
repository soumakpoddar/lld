package org.example;

public class Main {
    public static void main(String[] args) {
        ArithmeticExpression two = new Number(2);
        ArithmeticExpression three = new Number(3);
        ArithmeticExpression five = new Number(5);
        Expression eight = new Expression(three, five, Operator.ADD);
        Expression mulExp = new Expression(two, eight, Operator.MULTIPLY);
        System.out.println(mulExp.evaluate());
    }
}