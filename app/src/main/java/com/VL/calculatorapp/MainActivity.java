package com.VL.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNum1, etNum2, etOperation;
    private TextView tvRusultText;
    private Button btnCaltulateResult;
    private Toast toastError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNum1 = findViewById(R.id.op1);
        etNum2 = findViewById(R.id.op2);
        etOperation = findViewById(R.id.operation);
        tvRusultText = findViewById(R.id.result);
        btnCaltulateResult = findViewById(R.id.btn);
        btnCaltulateResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float num1, num2, result = 0;
        String operation;
        boolean correctOperation = true;

        try {
            num1 = Float.parseFloat(etNum1.getText().toString());
            num2 = Float.parseFloat(etNum2.getText().toString());
            operation = etOperation.getText().toString();
            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
                default:
                    correctOperation = false;
                    break;
            }
        } catch (Exception e) {
            toastError = Toast.makeText(this, R.string.some_error, Toast.LENGTH_SHORT);
            toastError.show();
            return;
        }
        if (correctOperation) {
            tvRusultText.setText(num1 + " " + operation + " " + num2 + " = " + result);
        }
        else {
            tvRusultText.setText(R.string.unknown_operation);
        }
    }
}