package com.posturedetection.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button;

    ArrayList<Person> persons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        persons = new ArrayList<>();
        persons.add(new Person("John", 20));
        persons.add(new Person("Mary", 21));

        button = findViewById(R.id.btnAdd);
        button.setOnClickListener(v -> {
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("persons", persons);
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("persons", persons);
            startActivity(intent);
        });

    }
}