package com.example.calculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView title;

    private Button simpleBtn;
    private Button advancedBtn;
    private Button aboutBtn;
    private Button exitBtn;

    private void init(){
        simpleBtn = findViewById(R.id.simpleBtn);
        advancedBtn = findViewById(R.id.advancedBtn);
        aboutBtn = findViewById(R.id.aboutBtn);
        exitBtn = findViewById(R.id.exitBtn);

        simpleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSimpleCalculator();
            }
        });

        advancedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAdvancedCalculator();
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApplication();
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        title.setTextColor(Color.WHITE);
        init();
    }

    private void openSimpleCalculator(){
        Intent intent = new Intent(MainActivity.this, SimpleActivity.class);
        startActivity(intent);
    }

    private void openAdvancedCalculator(){
        Intent intent = new Intent(getApplicationContext(), SimpleActivity.class);
        startActivity(intent);
    }

    private void openAbout(){
        Intent intent = new Intent(getApplicationContext(), SimpleActivity.class);
        startActivity(intent);
    }

    private void exitApplication(){
        finish();
        System.exit(0);
    }
}
