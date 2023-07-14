package com.posturedetection.myapplication6;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;

public class Globals extends Application {
    private ArrayList<Contact> contacts = new ArrayList<>();

    //get context
//    @Override
//    public Context getApplicationContext() {
//        return super.getApplicationContext();
//    }


    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
