package com.ushych.luxoft.models;

public enum MathOperation {
    PLUS("+"), MINUS("-"), MULTIPLICATION("*"), DIVISION("/");

    private String symbolOperation;

    private MathOperation(String symbol) {
        this.symbolOperation = symbol;
    }

    public String getSymbolOperation() {
        return symbolOperation;
    }
}
