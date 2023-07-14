package com.posturedetection.myapplication6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DetailActivity extends AppCompatActivity {

    TextView daTvName, daTvContact, daTvEmail,daTvGender,daTvDob;

    ImageView ivImg;
    ArrayList<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Integer position = intent.getIntExtra("position", 0);

        Globals globals = (Globals) getApplicationContext();
        contacts = globals.getContacts();

        Contact contact = contacts.get(position);


//        String name = intent.getStringExtra("name");
//        String contact = intent.getStringExtra("contact");
//        String email = intent.getStringExtra("email");

        daTvName = findViewById(R.id.daTvName);
        daTvContact = findViewById(R.id.daTvContact);
        daTvEmail = findViewById(R.id.daTvEmail);
        daTvGender = findViewById(R.id.daTvGender);
        daTvDob = findViewById(R.id.daTvDob);

//        daTvName.setText(name);
//        daTvContact.setText(contact);
//        daTvEmail.setText(email);

        daTvName.setText(contact.getName());
        daTvContact.setText(contact.getContact());
        daTvEmail.setText(contact.getEmail());
        daTvGender.setText(contact.isMale()?"Male":"Female");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(contact.getDob());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dobString = sdf.format(calendar.getTime());
        daTvDob.setText(dobString);

        ivImg = findViewById(R.id.ivImg);
        if(contact.isMale()){
            ivImg.setImageResource(R.drawable.man);

        }else{
            ivImg.setImageResource(R.drawable.woman);
        }





    }
}