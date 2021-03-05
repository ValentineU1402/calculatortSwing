package com.ushych.luxoft.controllers;

import java.util.ArrayList;
import java.util.List;

public class CalculateController {

    List<String> calculateHistory;

    public CalculateController() {
        this.calculateHistory = new ArrayList<>();
    }

    public String calculate(String firstInt, String operation, String secondInd) {
        float resultExpresion = 0;
        switch (operation) {
        case ("+"):
            resultExpresion = Float.parseFloat(firstInt) + Float.parseFloat(secondInd);
            break;
        case ("-"):
            resultExpresion = Float.parseFloat(firstInt) - Float.parseFloat(secondInd);
            break;
        case ("*"):
            resultExpresion = Float.parseFloat(firstInt) * Float.parseFloat(secondInd);
            break;
        case ("/"):
            resultExpresion = Float.parseFloat(firstInt) / Float.parseFloat(secondInd);
            break;
        default:
            break;
        }
        addCalculateHistory((firstInt + operation + secondInd) + " = " + resultExpresion + "\n");
        return Float.toString(resultExpresion);
    }

    private void addCalculateHistory(String expresion) {
        calculateHistory.add(expresion);
    }

    public String getCalculateHistory() {
        String result = "";
        for (String expresion : calculateHistory) {
            result += expresion;
        }
        return result;
    }

}
