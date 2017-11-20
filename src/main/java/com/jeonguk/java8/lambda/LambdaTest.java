package com.jeonguk.java8.lambda;

/**
 *  Why use Lambda Expression
 *      - To provide the implementation of Functional interface.
 *      - Less coding.
 *  Java Lambda Expression Syntax
 *      - (argument-list) -> {body}
 *  Java lambda expression is consisted of three components.
 *      - Argument-list: It can be empty or non-empty as well.
 *      - Arrow-token: It is used to link arguments-list and body of expression.
 *      - Body: It contains expressions and statements for lambda expression.
 */
public class LambdaTest {

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();

        MathOperation addition = (int a, int b) -> a + b;

        System.out.println("15 + 5 = " + lambdaTest.operate(15, 5, addition));
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
