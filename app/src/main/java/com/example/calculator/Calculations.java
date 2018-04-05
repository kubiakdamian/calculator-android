package com.example.calculator;

public class Calculations {
    public double subtraction(double firstNumber, double secondNumber){
        return firstNumber - secondNumber;
    }

    public double addition(double firstNumber, double secondNumber){
        return firstNumber + secondNumber;
    }

    public double multiplication(double firstNumber, double secondNumber){
        return firstNumber * secondNumber;
    }

    public double division(double firstNumber, double secondNumber){
        return firstNumber / secondNumber;
    }

    public double sin(double number){
        return Math.sin(number);
    }

    public double cos(double number){
        return Math.cos(number);
    }

    public double tan(double number){
        return Math.tan(number);
    }

    public double ln(double number){
        return Math.log(number);
    }

    public double log(double number){
        return Math.log10(number);
    }

    public double sqrt(double number){
        return Math.sqrt(number);
    }

    public double pow(double number){
        return Math.pow(number, 2);
    }

    public double pow(double firstNumber, double secondNumber){
        return Math.pow(firstNumber, secondNumber);
    }

}
