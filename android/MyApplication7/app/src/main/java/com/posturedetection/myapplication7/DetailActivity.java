package com.posturedetection.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        persons = (ArrayList<Person>) intent.getSerializableExtra("persons");

        Toast.makeText(this, persons.get(0).toString(), Toast.LENGTH_SHORT).show();
    }
}