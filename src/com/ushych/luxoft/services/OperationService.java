package com.ushych.luxoft.services;

public class OperationService {

    public float plus(float firstNumber, float secondNumber) {
        var result = firstNumber + secondNumber;
        return result;
    }

    public float minus(float firstNumber, float secondNumber) {
        var result = firstNumber - secondNumber;
        return result;
    }

    public float multiply(float firstNumber, float secondNumber) {
        var result = firstNumber * secondNumber;
        return result;
    }

    public float divide(float firstNumber, float secondNumber) {
        var result = firstNumber / secondNumber;
        return result;
    }
}
