package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber ="";
    String op = "+";
    boolean isNewOp = true;
    EditText ed1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1 = findViewById(R.id.editText);
    }

    public void numberEvent(View view) {
        if(isNewOp)
            ed1.setText("");
        isNewOp = false;
        String number = ed1.getText().toString();
        switch (view.getId()){
            case R.id.bu1:
                number += "1";
                break;
            case R.id.bu2:
                number += "2";
                break;
            case R.id.bu3:
                number += "3";
                break;
            case R.id.bu4:
                number += "5";
                break;
            case R.id.bu6:
                number += "6";
                break;
            case R.id.bu7:
                number += "7";
                break;
            case R.id.bu8:
                number += "8";
                break;
            case R.id.bu9:
                number += "9";
                break;
            case R.id.bu0:
                number += "0";
                break;
            case R.id.buDot:
                number += ".";
                break;
            case R.id.buPlusMinus:
                number = "-"+number;
                break;
        }
        ed1.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = ed1.getText().toString();
        switch (view.getId()){
            case R.id.buDivide: op = "/"; break;
            case R.id.buMultiply: op = "*"; break;
            case R.id.buPlus: op = "+"; break;
            case R.id.buMinus: op = "-"; break;
            case R.id.buSqrt: op = "x^2"; break;
            case R.id.buSqrt2: op = "√"; break;

        }
    }

    public void eqaulEvent(View view) {
        String newNumber = ed1.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
        }
        switch (op){
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
        }
        switch (op){
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
        }
        switch (op){
            case "/":
                result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                break;
        }
        switch (op){
            case "x^2":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(oldNumber);
                break;
        }
        ed1.setText(result+"");
    }

    public void acEvent(View view) {
        ed1.setText("0");
        isNewOp = true;
    }
    public void buSqrt(View view) {
        double no1 = Math.sqrt(Double.parseDouble(ed1.getText().toString()));
        ed1.setText(""+no1);
    }
}