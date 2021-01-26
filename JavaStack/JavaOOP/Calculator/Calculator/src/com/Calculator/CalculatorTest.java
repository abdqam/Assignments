package com.Calculator;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator calculate = new Calculator(2,"+",5);
        calculate.performOperation();
        System.out.println(calculate.getResults());
        Calculator calculate2 = new Calculator(10.5,"+",5.2);
        calculate2.performOperation();
        System.out.println(calculate2.getResults());
        Calculator calculate3 = new Calculator();
        calculate3.setOperandOne(22.2);
        calculate3.setOperandTwo(15.7);
        calculate3.setOperation("-");
        calculate3.performOperation();
        System.out.println(calculate3.getResults());
    }
}
