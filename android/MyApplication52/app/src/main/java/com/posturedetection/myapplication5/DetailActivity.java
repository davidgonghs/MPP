package com.posturedetection.myapplication5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView tvDetailName;

    ImageView ivDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int image = intent.getIntExtra("image", 0);
        tvDetailName = findViewById(R.id.tvDetailName);
        ivDetail = findViewById(R.id.ivDetail);

        tvDetailName.setText(name);
        ivDetail.setImageResource(image);
//        String name = intent.getStringExtra("name");
//        int age = intent.getIntExtra("age", 0);

//        textView = findViewById(R.id.tvDetailName);
//        textView.setText(name + "is" + age + "years old");
    }
}