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
    private boolean operationClicked;
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
        operationClicked = false;
        action = "none";
    }

    public void zeroBtnClicked(View view){
        input.append("0");
        refreshInput();
    }

    public void oneBtnClicked(View view){
        input.append("1");
        refreshInput();
    }

    public void twoBtnClicked(View view){
        input.append("2");
        refreshInput();
    }

    public void threeBtnClicked(View view){
        input.append("3");
        refreshInput();
    }

    public void fourBtnClicked(View view){
        input.append("4");
        refreshInput();
    }

    public void fiveBtnClicked(View view){
        input.append("5");
        refreshInput();
    }

    public void sixBtnClicked(View view){
        input.append("6");
        refreshInput();
    }

    public void sevenBtnClicked(View view){
        input.append("7");
        refreshInput();
    }

    public void eightBtnClicked(View view){
        input.append("8");
        refreshInput();
    }

    public void nineBtnClicked(View view){
        input.append("9");
        refreshInput();
    }

    public void separatorClicked(View view) {
        if (input.indexOf(".") != -1){
            return;
        }
        input.append(".");
        refreshInput();
    }

    public void subtractionBtnClicked(View view){
        action = "subtraction";
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(input.toString());
        }
        clearInput();
    }

    public void additionBtnClicked(View view){
        action = "addition";
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(input.toString());
        }
        clearInput();
    }

    public void multiplicationBtnClicked(View view){
        action = "multiplication";
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(input.toString());
        }
        clearInput();
    }

    public void divisionBtnClicked(View view){
        action = "division";
        if(firstNumber == 0){
            firstNumber = Double.parseDouble(input.toString());
        }
        clearInput();
    }


    public void equalsBtnClicked(View view){
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
                Toast.makeText(this.getApplicationContext(), "You cannot divide by 0!", Toast.LENGTH_LONG);
            }
        }

        setInputAsResult();
    }

    private void setInputAsResult(){
        input.setLength(0);
        input.append(Double.toString(firstNumber));
        refreshInput();
    }

    private void refreshInput(){
        resultText.setText(input);
    }

    private void clearInput(){
        input.setLength(0);
        refreshInput();
    }
}
