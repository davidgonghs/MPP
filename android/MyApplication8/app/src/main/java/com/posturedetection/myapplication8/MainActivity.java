package com.posturedetection.myapplication8;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShow, btnSave;
    EditText etName;
    Dialog dialog;

    String[] countries = {"Malaysia", "Singapore", "Usa", "China", "UK"};
    boolean[] options = {true, false, false, false, false};
    String myCountry = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow= findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.profile);
                etName = dialog.findViewById(R.id.etName);
                btnSave = dialog.findViewById(R.id.btnSave);

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = etName.getText().toString();
                        Toast.makeText(MainActivity.this, "Name: " + name, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


//        btnShow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
//                builder.setTitle("Alert Dialog");
//              //  builder.setMessage("This is an alert dialog");
//                builder.setCancelable(false);
//                builder.setMultiChoiceItems(countries, options, new DialogInterface.OnMultiChoiceClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
//                       // options[i] = b;
//                        String message = "";
//                        for(int j = 0; j < options.length; j++) {
//                            if (options[j] == true) {
//                                message += countries[j] + "\n";
//                            }
//                        }
//                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
//                        //System.out.println("My country is: " + message);
//                    }
//                });
////                builder.setItems(countries, new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialogInterface, int i) {
////                        myCountry = countries[i];
////                        System.out.println("My country is: " + myCountry);
////                        dialogInterface.dismiss();
////                    }
////                });
//
//
//                builder.setPositiveButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        dialogInterface.dismiss();
//                    }
//                });
//              //  builder.setNegativeButton("Cancel", null);
//                AlertDialog alertDialog= builder.create();
//                alertDialog.show();
//
//            }
//        });

    }
}