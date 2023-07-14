package com.posturedetection.myapplication5;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

public class Globals extends Application {
    private String[] names;
    private TypedArray images;

    @Override
    public void onCreate() {
        super.onCreate();
        initResources();
    }

    private void initResources() {
        Context context = getApplicationContext();
        Resources resources = context.getResources();
        names = resources.getStringArray(R.array.names);
        images = resources.obtainTypedArray(R.array.images);
    }

    public String[] getNames() {
        return names;
    }

    public TypedArray getImages() {
        return images;
    }
}
