package com.posturedetection.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView output;
    EditText et1,et2,et3,et4;
    Button cal1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the reference of the widgets
        output = (TextView) findViewById(R.id.output);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        cal1 = (Button) findViewById(R.id.cal1);

        //listener for button , when button is clicked , the function is called
        cal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the values from the edit text
                String n1 = et1.getText().toString();
                String n2 = et2.getText().toString();
                String n3 = et3.getText().toString();
                String n4 = et4.getText().toString();

                //a simple car loan calculator
                //n1 is amount , n2 is down  , n3 is the percentage of interest , n4 is years to calculator monthly payment
                double amount = Double.parseDouble(n1);
                double down = Double.parseDouble(n2);
                double interest = Double.parseDouble(n3)/100;
                double years = Double.parseDouble(n4);
                double principal = amount-down;

                //calculate the monthly payment

                //double result = (principal+principal*interest)/(years*12);
                double result = (principal + (principal*interest*years))/(years*12);

                //display the result
                output.setText("Monthly Payment = "+result);
            }
        });

    }
}