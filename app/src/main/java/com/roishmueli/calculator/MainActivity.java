package com.roishmueli.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.DuplicateFormatFlagsException;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView screen;
    String display = "";
    String currentOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen = (TextView)findViewById(R.id.screen);
        screen.setText(display);

    }

    private void updateScreen(){
        screen.setText(display);
    }
    public void onClickNumber(View v){
        Button btn = (Button)v;
        display += btn.getText();
        updateScreen();
    }
    public void onClickOperator(View v){
        Button btn = (Button)v;
        display += btn.getText();
        currentOperator = btn.getText().toString();
        updateScreen();
    }

    public void onClickClear(View v){
        display = "";
        currentOperator = "";
        updateScreen();
    }
    private double operate(String a, String b, String op){
        switch (op){
            case "+":
                return Double.valueOf(a) + Double.valueOf(b);
            case "-":
                return Double.valueOf(a) - Double.valueOf(b);
            case "*":
                return Double.valueOf(a) * Double.valueOf(b);
            case "/":
                return Double.valueOf(a) / Double.valueOf(b);
            default:
                return -1;

        }
    }

    public void onClickEqual(View v){
        String[] opration = display.split(Pattern.quote(currentOperator));
        if (opration.length < 2) return;

        Double result = operate(opration[0], opration[1], currentOperator);
        screen.setText(display + "\n" + String.valueOf(result));
    }
}
