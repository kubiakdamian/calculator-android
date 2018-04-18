package com.example.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SimpleActivity extends AppCompatActivity {

    private Calculations calculations;
    private EditText resultText;
    private StringBuilder input;
    private double firstNumber;
    private double secondNumber;
    private double result;
    private boolean equalsClicked;
    private boolean isResultDisplayed;
    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        calculations = new Calculations();
        init();
    }

    private void init(){
        resultText = findViewById(R.id.resultText);
        resultText.setTextColor(Color.WHITE);
        input = new StringBuilder();
        resultText.setText(input);
        equalsClicked = true;
        isResultDisplayed = false;
        action = "none";
    }

    public void zeroBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("0");
            refreshInput();
        }
    }

    public void oneBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("1");
            refreshInput();
        }
    }

    public void twoBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("2");
            refreshInput();
        }
    }

    public void threeBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("3");
            refreshInput();
        }
    }

    public void fourBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("4");
            refreshInput();
        }
    }

    public void fiveBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("5");
            refreshInput();
        }
    }

    public void sixBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("6");
            refreshInput();
        }
    }

    public void sevenBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("7");
            refreshInput();
        }
    }

    public void eightBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("8");
            refreshInput();
        }
    }

    public void nineBtnClicked(View view){
        if(!isResultDisplayed){
            input.append("9");
            refreshInput();
        }
    }

    public void separatorClicked(View view) {
        if (input.indexOf(".") != -1){
            return;
        }
        input.append(".");
        refreshInput();
    }

    public void additionBtnClicked(View view){
        if(input.length() > 0) {
            if (equalsClicked) {
                action = "addition";
                if (firstNumber == 0) {
                    firstNumber = Double.parseDouble(input.toString());
                }
            } else {
                makeCalculations();
                action = "addition";
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            isResultDisplayed = false;
            equalsClicked = false;
            clearInput();
        }
    }

    public void subtractionBtnClicked(View view){
        if(input.length() > 0) {
            if (equalsClicked) {
                action = "subtraction";
                if (firstNumber == 0) {
                    firstNumber = Double.parseDouble(input.toString());
                }
            } else {
                makeCalculations();
                action = "subtraction";
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            equalsClicked = false;
            isResultDisplayed = false;
            clearInput();
        }
    }

    public void multiplicationBtnClicked(View view){
        if(input.length() > 0) {
            if (equalsClicked) {
                action = "multiplication";
                if (firstNumber == 0) {
                    firstNumber = Double.parseDouble(input.toString());
                }
            } else {
                makeCalculations();
                action = "multiplication";
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            isResultDisplayed = false;
            equalsClicked = false;
            clearInput();
        }
    }

    public void divisionBtnClicked(View view){
        if(input.length() > 0) {
            if (equalsClicked) {
                action = "division";
                if (firstNumber == 0) {
                    firstNumber = Double.parseDouble(input.toString());
                }
            } else {
                makeCalculations();
                action = "division";
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            isResultDisplayed = false;
            equalsClicked = false;
            clearInput();
        }
    }

    public void clearBtnClicked(View view){
        firstNumber = 0;
        isResultDisplayed = false;
        equalsClicked = true;
        clearInput();
    }

    public void bkspBtnClicked(View view) {
        if(!isResultDisplayed){
            if(input.length() > 0){
                input = input.deleteCharAt(input.length() - 1);
            }
        }
        refreshInput();
    }

    public void changeBtnClicked(View view){
        try{
            double value = Double.parseDouble(input.toString());
            if(value < 0){
                input.deleteCharAt(0);
            }
            else if(value > 0){
                input.insert(0,"-");
            }
            firstNumber = Double.parseDouble(input.toString());
        }
        catch(NumberFormatException ignored){
        }
        refreshInput();
    }

    public void equalsBtnClicked(View view){
        if(input.length() != 0){
            if(!equalsClicked){
                makeCalculations();
                setInputAsResult();
            }
            equalsClicked = true;
            isResultDisplayed = true;
        }
    }

    private void setInputAsResult(){
        input.setLength(0);
        input.append(Double.toString(firstNumber));
        refreshInput();
    }

    private void makeCalculations(){
        secondNumber = Double.parseDouble(input.toString());
        if(action.equals("subtraction")){
            result = calculations.subtraction(firstNumber, secondNumber);
            firstNumber = result;
        }else if(action.equals("addition")){
            result = calculations.addition(firstNumber, secondNumber);
            firstNumber = result;
        }else if(action.equals("multiplication")){
            result = calculations.multiplication(firstNumber, secondNumber);
            firstNumber = result;
        }else if(action.equals("division")){
            if(secondNumber != 0){
                result = calculations.division(firstNumber, secondNumber);
                firstNumber = result;
            }else{
                Toast.makeText(getBaseContext(), "You cannot divide by 0!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void refreshInput(){
        resultText.setText(input);
    }

    private void clearInput(){
        input.setLength(0);
        refreshInput();
    }
}
