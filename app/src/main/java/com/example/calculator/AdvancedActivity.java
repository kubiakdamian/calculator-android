package com.example.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdvancedActivity extends AppCompatActivity {

    private Calculations calculations;
    private EditText resultText;
    private StringBuilder input;
    private double firstNumber;
    private double secondNumber;
    private double result;
    private boolean equalsClicked;
    private boolean isResultDisplayed;
    private boolean isAdvancedOperation;
    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced);
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
        isAdvancedOperation = false;
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
            } else if(!isAdvancedOperation) {
                makeCalculations();
                action = "addition";
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            isResultDisplayed = false;
            equalsClicked = false;
            isAdvancedOperation = false;
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
            } else if(!isAdvancedOperation){
                makeCalculations();
                action = "subtraction";
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            equalsClicked = false;
            isResultDisplayed = false;
            isAdvancedOperation = false;
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
            } else if(!isAdvancedOperation){
                makeCalculations();
                action = "multiplication";
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            isResultDisplayed = false;
            equalsClicked = false;
            isAdvancedOperation = false;
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
            } else if(!isAdvancedOperation){
                makeCalculations();
                action = "division";
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            isResultDisplayed = false;
            equalsClicked = false;
            isAdvancedOperation = false;
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

    public void logBtnClicked(View view){
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            if(firstNumber > 0){
                action = "log";
                makeCalculations();

                isResultDisplayed = true;
                equalsClicked = true;
                isAdvancedOperation = true;
                setInputAsResult();
            }else{
                Toast.makeText(getBaseContext(), "Number has to be greater than 0!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void lnBtnClicked(View view){
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            if(firstNumber > 0){
                action = "ln";
                makeCalculations();

                isResultDisplayed = true;
                equalsClicked = true;
                isAdvancedOperation = true;
                setInputAsResult();
            }else{
                Toast.makeText(getBaseContext(), "Number has to be greater than 0!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void sinBtnClicked(View view){
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            action = "sin";
            makeCalculations();

            isResultDisplayed = true;
            equalsClicked = true;
            isAdvancedOperation = true;
            setInputAsResult();
        }
    }

    public void cosBtnClicked(View view){
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            action = "cos";
            makeCalculations();

            isResultDisplayed = true;
            equalsClicked = true;
            isAdvancedOperation = true;
            setInputAsResult();
        }
    }

    public void tanBtnClicked(View view){
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            action = "tan";
            makeCalculations();

            isResultDisplayed = true;
            equalsClicked = true;
            isAdvancedOperation = true;
            setInputAsResult();
        }
    }

    public void sqrtBtnClicked(View view){
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            if(firstNumber > 0){
                action = "sqrt";
                makeCalculations();

                isResultDisplayed = true;
                equalsClicked = true;
                isAdvancedOperation = true;
                setInputAsResult();
            }else{
                Toast.makeText(getBaseContext(), "Number has to be greater than 0!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void powBtnClicked(View view){
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            action = "pow";
            makeCalculations();

            isResultDisplayed = true;
            equalsClicked = true;
            isAdvancedOperation = true;
            setInputAsResult();
        }
    }

    public void powToYBtnClicked(View view){
        if(input.length() > 0) {
            if (equalsClicked) {
                action = "powToY";
                if (firstNumber == 0) {
                    firstNumber = Double.parseDouble(input.toString());
                }
            } else{
                makeCalculations();
                action = "powToY";
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            isResultDisplayed = false;
            equalsClicked = false;
            isAdvancedOperation = false;
            clearInput();
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
        }else if(action.equals("log")){
            result = calculations.log(firstNumber);
            firstNumber = result;
        }else if(action.equals("ln")){
            result = calculations.ln(firstNumber);
            firstNumber = result;
        }else if(action.equals("sin")){
            result = calculations.sin(firstNumber);
            firstNumber = result;
        }else if(action.equals("cos")){
            result = calculations.cos(firstNumber);
            firstNumber = result;
        }else if(action.equals("tan")){
            result = calculations.tan(firstNumber);
            firstNumber = result;
        }else if(action.equals("sqrt")){
            result = calculations.sqrt(firstNumber);
            firstNumber = result;
        }else if(action.equals("pow")){
            result = calculations.pow(firstNumber);
            firstNumber = result;
        }else if(action.equals("powToY")){
            result = calculations.pow(firstNumber, secondNumber);
            firstNumber = result;
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
