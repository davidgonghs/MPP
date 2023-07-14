package com.posturedetection.myapplication4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RadioGroup rgGender;
    Button btnRun, btnTest;

    String[] countries;
    Spinner spCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgGender = findViewById(R.id.rgGender);
        btnRun = findViewById(R.id.btnRun);
        btnTest = findViewById(R.id.btnTest);

        countries = getResources().getStringArray(R.array.country);
        spCountry = findViewById(R.id.spCountry);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, countries);
        spCountry.setAdapter(adapter);



//        btnRun.setOnClickListener(v -> {
//            int selectedId = rgGender.getCheckedRadioButtonId();
//            if (selectedId == R.id.rbMale) {
//                // do something
//                Toast.makeText(MainActivity.this,"Male",Toast.LENGTH_SHORT).show();
//            } else if (selectedId == R.id.rbFemale) {
//                // do something
//                Toast.makeText(MainActivity.this,"Female",Toast.LENGTH_SHORT).show();
//            }
//        });

    }


    //        rewrite onClick funtion
    @Override
    public void onClick(View view){
        int id = view.getId();
        if(id==R.id.btnRun){
            int selectedId = rgGender.getCheckedRadioButtonId();
            if (selectedId == R.id.rbMale) {
                // do something
                Toast.makeText(MainActivity.this,"Male",Toast.LENGTH_SHORT).show();
            } else if (selectedId == R.id.rbFemale) {
                // do something
                Toast.makeText(MainActivity.this,"Female",Toast.LENGTH_SHORT).show();
            }
        }

        if(id==R.id.btnTest){
            Toast.makeText(MainActivity.this,"Test",Toast.LENGTH_SHORT).show();
        }
    }

}