package com.ushych.luxoft.controllers;

import java.util.ArrayList;
import java.util.List;

public class CalculateController {

    List<String> calculateHistory;

    public CalculateController() {
        this.calculateHistory = new ArrayList<>();
    }

    public String calculate(String firstInt, String operation, String secondInd) {
        int resultExpresion = 0;
        switch (operation) {
            case ("+"):
                resultExpresion = Integer.parseInt(firstInt) + Integer.parseInt(secondInd);
                break;
            case ("-"):
                resultExpresion = Integer.parseInt(firstInt) - Integer.parseInt(secondInd);
                break;
            case ("*"):
                resultExpresion = Integer.parseInt(firstInt) * Integer.parseInt(secondInd);
                break;
            case ("/"):
                resultExpresion = Integer.parseInt(firstInt) / Integer.parseInt(secondInd);
                break;
            default:
                break;
        }
        addCalculateHistory((firstInt + operation + secondInd) + " = " + resultExpresion);
        return Integer.toString(resultExpresion);
    }

    private void addCalculateHistory(String expresion) {
        calculateHistory.add(expresion);
    }

    public List<String> getCalculateHistory() {
        return calculateHistory;
    }

}
