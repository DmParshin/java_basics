package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator(5, 4);
        calculator.calc(Operation.MULTIPLY);
    }
}
