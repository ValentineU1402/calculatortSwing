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
        var result = "";
        if (checkInput(firstInt, operation, secondInt)) {
            switch (operation) {
            case ("+"):
                result = String.valueOf(service.plus(parseFloat(firstInt), parseFloat(secondInt)));
                break;
            case ("-"):
                result = String.valueOf(service.minus(parseFloat(firstInt), parseFloat(secondInt)));
                break;
            case ("*"):
                result = String.valueOf(service.multiply(parseFloat(firstInt), parseFloat(secondInt)));
                break;
            case ("/"):
                if (Float.parseFloat(secondInt) == 0.0) {
                    result = "divide by zero";
                    break;
                }
                if (checkInput(firstInt, operation, secondInt)) {
                    result = String.valueOf(service.divide(parseFloat(firstInt), parseFloat(secondInt)));
                } else {

                }
                break;
            default:
                break;
            }
        } else {
            result = "Incorect input";
        }
        addCalculateHistory((firstInt + operation + secondInt) + " = " + result);
        return result;
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
        if ((!first.isBlank() && !first.isEmpty()) && (!second.isBlank() && !second.isEmpty())) {
            result = true;
        }
        if (!(first.length() > 0 || second.length() > 0) && (first.charAt(0) == '0' || second.charAt(0) == '0')) {
            result = false;
        }
        return result;
    }

    public String getCalculateHistory() {
        return calculateHistory.stream().map(expression -> String.valueOf(expression))
                .collect(Collectors.joining("\n"));
    }

}
