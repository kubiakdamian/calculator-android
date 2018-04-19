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

        if(savedInstanceState != null){
            firstNumber = savedInstanceState.getDouble("firstNumber");
            secondNumber = savedInstanceState.getDouble("secondNumber");
            action = savedInstanceState.getString("action");
            equalsClicked = savedInstanceState.getBoolean("equalsClicked");
            isResultDisplayed = savedInstanceState.getBoolean("isResultDisplayed");
            isAdvancedOperation = savedInstanceState.getBoolean("isAdvancedOperation");
            input.append(savedInstanceState.getString("input"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putDouble("firstNumber", firstNumber);
        outState.putDouble("secondNumber", secondNumber);
        outState.putString("action", action);
        outState.putBoolean("equalsClicked", equalsClicked);
        outState.putBoolean("isResultDisplayed", isResultDisplayed);
        outState.putBoolean("isAdvancedOperation", isAdvancedOperation);
        outState.putString("input", input.toString());

        super.onSaveInstanceState(outState);
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
        if(input.length() > 0){
            input.append(".");
        }
        refreshInput();
    }

    public void additionBtnClicked(View view){
        twoNumbersOperation("addition");
    }

    public void subtractionBtnClicked(View view){
        twoNumbersOperation("subtraction");
    }

    public void multiplicationBtnClicked(View view){
        twoNumbersOperation("multiplication");
    }

    public void divisionBtnClicked(View view){
        twoNumbersOperation("division");
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
        if(!isResultDisplayed){
            makeCalculations();
        }
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            if(firstNumber > 0){
                action = "log";
                makeCalculations();
                setSingleNumberOperationFlags();
                setInputAsResult();
            }else{
                Toast.makeText(getBaseContext(), "Number has to be greater than 0!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void lnBtnClicked(View view){
        if(!isResultDisplayed){
            makeCalculations();
        }
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            if(firstNumber > 0){
                action = "ln";
                makeCalculations();
                setSingleNumberOperationFlags();
                setInputAsResult();
            }else{
                Toast.makeText(getBaseContext(), "Number has to be greater than 0!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void sinBtnClicked(View view){
        singleNumberOperation("sin");
    }

    public void cosBtnClicked(View view){
        singleNumberOperation("cos");
    }

    public void tanBtnClicked(View view){
        singleNumberOperation("tan");
    }

    public void sqrtBtnClicked(View view){
        if(!isResultDisplayed){
            makeCalculations();
        }
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            if(firstNumber > 0){
                action = "sqrt";
                makeCalculations();
                setSingleNumberOperationFlags();
                setInputAsResult();
            }else{
                Toast.makeText(getBaseContext(), "Number has to be greater than 0!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void powBtnClicked(View view){
        singleNumberOperation("pow");
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
            setTwoNumbersOperationFlags();
            clearInput();
        }
    }

    private void twoNumbersOperation(String actionType){
        if(input.length() > 0) {
            if (equalsClicked) {
                action = actionType;
                if (firstNumber == 0) {
                    firstNumber = Double.parseDouble(input.toString());
                }
            } else if(!isAdvancedOperation) {
                makeCalculations();
                action = actionType;
                Toast.makeText(getBaseContext(), String.valueOf(firstNumber), Toast.LENGTH_SHORT).show();
            }
            setTwoNumbersOperationFlags();
            clearInput();
        }
    }

    private void singleNumberOperation(String actionType){
        if(!isResultDisplayed){
            makeCalculations();
        }
        if(input.length() > 0) {
            if (firstNumber == 0) {
                firstNumber = Double.parseDouble(input.toString());
            }
            action = actionType;
            makeCalculations();
            setSingleNumberOperationFlags();
            setInputAsResult();
        }
    }

    private void setTwoNumbersOperationFlags(){
        isResultDisplayed = false;
        equalsClicked = false;
        isAdvancedOperation = false;
    }

    private void setSingleNumberOperationFlags(){
        isResultDisplayed = true;
        equalsClicked = true;
        isAdvancedOperation = true;
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
            if(Double.isInfinite(result)){
                Toast.makeText(getBaseContext(), "The number is too large!", Toast.LENGTH_SHORT).show();
            }else{
                firstNumber = result;
            }
        }else if(action.equals("powToY")){
            result = calculations.pow(firstNumber, secondNumber);
            if(Double.isInfinite(result)){
                Toast.makeText(getBaseContext(), "The number is too large!", Toast.LENGTH_SHORT).show();
            }else{
                firstNumber = result;
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
