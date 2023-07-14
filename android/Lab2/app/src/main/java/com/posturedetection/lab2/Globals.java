package com.posturedetection.lab2;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;

public class Globals extends Application {

    private ArrayList<Zodiac> zodiacs = new ArrayList<>();

    private TypedArray images;

    public ArrayList<Zodiac> getZodiacs() {
        return zodiacs;
    }

    //getImages
    public TypedArray getImages() {
        return images;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initResources();
    }

    private void initResources() {
        Context context = getApplicationContext();
        Resources resources = context.getResources();
        String[] names = resources.getStringArray(R.array.names);
        String[] dates = resources.getStringArray(R.array.dates);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        images = resources.obtainTypedArray(R.array.images);

        for (int i = 0; i < names.length; i++) {
            zodiacs.add(new Zodiac(names[i], dates[i], descriptions[i]));
        }
    }





}
