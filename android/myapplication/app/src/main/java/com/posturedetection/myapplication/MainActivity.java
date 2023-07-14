package com.posturedetection.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNum1,etNum2,etNum3;
    Button btnAvg,btnMax,btnMin,btnCalculate;
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1=findViewById(R.id.etNum1);
        etNum2=findViewById(R.id.etNum2);
        etNum3=findViewById(R.id.etNum3);
        btnAvg=findViewById(R.id.btnAvg);
        btnMax=findViewById(R.id.btnMax);
        btnMin=findViewById(R.id.btnMin);
        btnCalculate=findViewById(R.id.btnCalculate);
        tvOutput=findViewById(R.id.tvOutput);

        btnCalculate.setOnClickListener(v -> {
            int num1=Integer.parseInt(etNum1.getText().toString());
            int num2=Integer.parseInt(etNum2.getText().toString());
            int num3=Integer.parseInt(etNum3.getText().toString());
            int sum=num1+num2+num3;
            tvOutput.setText("Sum is "+sum);
        });

        btnAvg.setOnClickListener(v -> {
            int num1=Integer.parseInt(etNum1.getText().toString());
            int num2=Integer.parseInt(etNum2.getText().toString());
            int num3=Integer.parseInt(etNum3.getText().toString());
            int avg=(num1+num2+num3)/3;
            tvOutput.setText("Average is "+avg);
        });

        btnMax.setOnClickListener(v -> {
            int num1=Integer.parseInt(etNum1.getText().toString());
            int num2=Integer.parseInt(etNum2.getText().toString());
            int num3=Integer.parseInt(etNum3.getText().toString());
            int max=num1;
            if(num2>max)
                max=num2;
            if(num3>max)
                max=num3;
            tvOutput.setText("Maximum is "+max);
        });

        btnMin.setOnClickListener(v -> {
            int num1=Integer.parseInt(etNum1.getText().toString());
            int num2=Integer.parseInt(etNum2.getText().toString());
            int num3=Integer.parseInt(etNum3.getText().toString());
            int min=num1;
            if(num2<min)
                min=num2;
            if(num3<min)
                min=num3;
            tvOutput.setText("Minimum is "+min);
        });

    }
}