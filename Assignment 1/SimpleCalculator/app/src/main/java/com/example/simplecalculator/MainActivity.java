package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private TextView display;
    private double firstValue = 0, secondValue = 0;
    private String operator = "";
    private boolean isOperatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Set click listeners for number buttons
        setNumberButtonListeners();

        // Set click listeners for operator buttons
        setOperatorButtonListeners();


    }

    private void setOperatorButtonListeners() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String value = button.getText().toString();
                if (isOperatorPressed) {
                    display.setText(value);
                    isOperatorPressed = false;
                } else {
                    display.append(value);
                }
            }
        };
        findViewById(R.id.btn0).setOnClickListener(listener);
        findViewById(R.id.btn1).setOnClickListener(listener);
        findViewById(R.id.btn2).setOnClickListener(listener);
        findViewById(R.id.btn3).setOnClickListener(listener);
        findViewById(R.id.btn4).setOnClickListener(listener);
        findViewById(R.id.btn5).setOnClickListener(listener);
        findViewById(R.id.btn6).setOnClickListener(listener);
        findViewById(R.id.btn7).setOnClickListener(listener);
        findViewById(R.id.btn8).setOnClickListener(listener);
        findViewById(R.id.btn9).setOnClickListener(listener);

    }

    private void setNumberButtonListeners() {

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;
                String operation = button.getText().toString();
                if (!operation.equals("=")) {
                    firstValue = Double.parseDouble(display.getText().toString());
                    operator = operation;
                    isOperatorPressed = true;
                } else {
                    secondValue = Double.parseDouble(display.getText().toString());
                    double result = performCalculation(firstValue, secondValue, operator);
                    display.setText(String.valueOf(result));
                }
            }
        };
        findViewById(R.id.btnAdd).setOnClickListener(listener);
        findViewById(R.id.btnSubtract).setOnClickListener(listener);
        findViewById(R.id.btnMultiply).setOnClickListener(listener);
        findViewById(R.id.btnDivide).setOnClickListener(listener);
        findViewById(R.id.btnPercent).setOnClickListener(listener);
        findViewById(R.id.btnEquals).setOnClickListener(listener);
        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("0");
                firstValue = 0;
                secondValue = 0;
                operator = "";

            }
        });
    }

    private double performCalculation(double firstValue, double secondValue, String operator) {
        switch (operator) {
            case "+":
                return firstValue + secondValue;
            case "-":
                return firstValue - secondValue;
            case "*":
                return firstValue * secondValue;
            case "/":
                return firstValue / secondValue;
            case "%":
                return firstValue % secondValue;
            default:
                return 0;
        }
    }
}