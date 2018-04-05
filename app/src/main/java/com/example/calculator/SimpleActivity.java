package com.example.calculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SimpleActivity extends AppCompatActivity {

    private EditText resultText;
    private StringBuilder input;
    private double firstNumber;
    private double secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        init();
    }

    private void init(){
        resultText = findViewById(R.id.resultText);
        resultText.setTextColor(Color.WHITE);
        input = new StringBuilder();
        resultText.setText(input);
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
        if(input.length() <= 0){
            input.append("-");
        }else{

        }

        refreshInput();
    }

    private void refreshInput(){
        resultText.setText(input);
    }
}
