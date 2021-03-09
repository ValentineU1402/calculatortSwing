package com.ushych.luxoft.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ushych.luxoft.services.OperationService;

public class CalculateController {

    private List<String> calculateHistory;
    private OperationService service;

    public CalculateController() {
        this.calculateHistory = new ArrayList<>();
        this.service = new OperationService();
    }

    public String calculate(String firstInt, String operation, String secondInt) {
        var result = 0f;
        switch (operation) {
        case ("+"):
            checkInput(firstInt, operation, secondInt);
            result = service.plus(parseFloat(firstInt), parseFloat(secondInt));
            break;
        case ("-"):
            result = service.minus(parseFloat(firstInt), parseFloat(secondInt));
            break;
        case ("*"):
            result = service.multiply(parseFloat(firstInt), parseFloat(secondInt));
            break;
        case ("/"):
            result = service.divide(parseFloat(firstInt), parseFloat(secondInt));
            break;
        default:
            break;
        }
        addCalculateHistory((firstInt + operation + secondInt) + " = " + result);
        return String.valueOf(result);
    }

    private float parseFloat(String number) {
        var result = Float.parseFloat(number);
        return result;
    }

    private void addCalculateHistory(String expresion) {
        calculateHistory.add(expresion);
    }

    private boolean checkInput(String first, String operation, String second) {
        var result = false;
        if ((first.isBlank() && first.isEmpty()) && (second.isBlank() && second.isEmpty())) {
            result = false;
        }

        if (operation.equals("/")) {
            if (Float.parseFloat(second) == 0.) {
                result = false;
            }
        }
        return result;
    }

    public String getCalculateHistory() {
        return calculateHistory.stream().map(expression -> String.valueOf(expression))
                .collect(Collectors.joining("\n"));
    }

}
