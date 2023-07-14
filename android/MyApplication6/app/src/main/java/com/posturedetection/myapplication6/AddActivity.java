package com.posturedetection.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

public class AddActivity extends AppCompatActivity {

    EditText aa_etName, aa_etContact, aa_etEmail;
    Button aa_btnSave, aa_btnCancel;

    CheckBox aa_cb_is_male;


    DatePicker dp;
    TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Globals globals = (Globals) getApplicationContext();
        globals.getContacts();

        dp = findViewById(R.id.dpDate);
        tp = findViewById(R.id.tpTime);


        aa_etName = findViewById(R.id.aa_etName);
        aa_etContact = findViewById(R.id.aa_etContact);
        aa_etEmail = findViewById(R.id.aa_etEmail);
        aa_btnSave = findViewById(R.id.aa_btnSave);
        aa_btnCancel = findViewById(R.id.aa_btnCancel);
        aa_cb_is_male = findViewById(R.id.aa_cb_is_male);


        aa_btnSave.setOnClickListener(v -> {
            String name = aa_etName.getText().toString();
            String contact = aa_etContact.getText().toString();
            String email = aa_etEmail.getText().toString();

            Calendar calendar = Calendar.getInstance();
            calendar.set(dp.getYear(),dp.getMonth(),dp.getDayOfMonth(),tp.getHour(),tp.getMinute(),0);
            long timeInMillis = calendar.getTimeInMillis();

            Contact newContact = new Contact(name,contact,email,aa_cb_is_male.isChecked(),timeInMillis);
            globals.getContacts().add(newContact);
            finish();
        });

        aa_btnCancel.setOnClickListener(v -> {

            finish();
        });



    }
}