package com.Calculator;

public class Calculator {
    private double operandOne = 0.0;
    private String operation = "";
    private double operandTwo = 0.0;
    private double result = 0.0;

    public Calculator() {
    }

    public Calculator(double operandOne, String operation, double operandTwo) {
        this.operandOne = operandOne;
        this.operation = operation;
        this.operandTwo = operandTwo;
    }

    public double getOperandOne() {
        return operandOne;
    }

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public double getOperandTwo() {
        return operandTwo;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
    public void performOperation(){
        if(getOperation().equals("+")){
            setResult(getOperandOne()+getOperandTwo());
        }
        else if(getOperation().equals("-")){
            setResult(getOperandOne()-getOperandTwo());
        }
    }
    public double getResults(){
        return getResult();
    }
}
