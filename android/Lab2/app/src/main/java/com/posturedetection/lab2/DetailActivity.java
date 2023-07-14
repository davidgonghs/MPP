package com.posturedetection.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView adTvName, adTvDate,adTvDesc;

    ImageView adIvImg;

    ArrayList<Zodiac> zodiacs;

    TypedArray images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Integer position = intent.getIntExtra("position", 0);
        int image = intent.getIntExtra("image", 0);

        Globals globals = (Globals) getApplicationContext();
        zodiacs = globals.getZodiacs();
        images = globals.getImages();

        Zodiac zodiac = zodiacs.get(position);

        adIvImg = findViewById(R.id.adIvImg);
        adTvName = findViewById(R.id.adTvName);
        adTvDate = findViewById(R.id.adTvDate);
        adTvDesc = findViewById(R.id.adTvDesc);

        adIvImg.setImageResource(image);
        adTvName.setText(zodiac.getName());
        adTvDate.setText(zodiac.getDate());
        adTvDesc.setText(zodiac.getDescription());

    }
}