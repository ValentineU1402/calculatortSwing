package com.ushych.luxoft.controllers;

import java.util.ArrayList;
import java.util.List;

public class CalculateController {

    List<String> calculateHistory;

    public CalculateController() {
        this.calculateHistory = new ArrayList<>();
    }

    public String calculate(String firstInt, String operation, String secondInt) {
        String result = "";
        switch (operation) {
        case ("+"):
            result = plus(firstInt, secondInt);
            break;
        case ("-"):
            result = minus(firstInt, secondInt);
            break;
        case ("*"):
            result = multiply(firstInt, secondInt);
            break;
        case ("/"):
            result = divide(firstInt, secondInt);
            break;
        default:
            break;
        }
        addCalculateHistory((firstInt + operation + secondInt) + " = " + result + "\n");
        return result;
    }

    private void addCalculateHistory(String expresion) {
        calculateHistory.add(expresion);
    }

    private String plus(String firstNumber, String secondNumber) {
        float result = Float.parseFloat(firstNumber) + Float.parseFloat(secondNumber);
        return String.valueOf(result);
    }

    private String minus(String firstNumber, String secondNumber) {
        float result = Float.parseFloat(firstNumber) - Float.parseFloat(secondNumber);
        return String.valueOf(result);
    }

    private String multiply(String firstNumber, String secondNumber) {
        float result = Float.parseFloat(firstNumber) * Float.parseFloat(secondNumber);
        return String.valueOf(result);
    }

    private String divide(String firstNumber, String secondNumber) {
        if (Float.parseFloat(secondNumber) == 0) {
            return "division by zero";
        }
        float result = Float.parseFloat(firstNumber) / Float.parseFloat(secondNumber);
        return String.valueOf(result);
    }

    public String getCalculateHistory() {
        String result = "";
        for (String expresion : calculateHistory) {
            result += expresion;
        }
        return result;
    }

}
