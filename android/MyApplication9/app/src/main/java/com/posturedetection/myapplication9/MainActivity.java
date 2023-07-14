package com.posturedetection.myapplication9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    TextView tvOutput;

    DatePickerDialog dpDialog;

    TimePickerDialog tpDialog;

    DatePicker dp;
    TimePicker tp;


    int myDay, myMonth, myYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);
        tvOutput = findViewById(R.id.tvOutput);
        dp = findViewById(R.id.dpDate);
        tp = findViewById(R.id.tpTime);



        btnShow.setOnClickListener(v -> {
//            int hour = tp.getHour();
//            int minute = tp.getMinute();
//            Toast.makeText(MainActivity.this, "Time: " + hour + ":" + minute, Toast.LENGTH_SHORT).show();
//
           // tvOutput.setText("Hello World");
            Calendar calendar = Calendar.getInstance();

           // calendar.add(Calendar.DAY_OF_YEAR,7);

            int calendarYear = calendar.get(Calendar.YEAR);
            int calendarMonth = calendar.get(Calendar.MONTH)+1;
            int calendarDay = calendar.get(Calendar.DAY_OF_MONTH);
            int calenderDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            int calendarHour = calendar.get(Calendar.HOUR_OF_DAY);
            int calendarMinute = calendar.get(Calendar.MINUTE);
            int calendarSecond = calendar.get(Calendar.SECOND);

            calendar.set(dp.getYear(),dp.getMonth(),dp.getDayOfMonth(),tp.getHour(),tp.getMinute(),0);
           // Toast.makeText(MainActivity.this, "Time: " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE), Toast.LENGTH_SHORT).show();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String currentDateandTime = sdf.format(calendar.getTime());
            tvOutput.setText(currentDateandTime);

            //date picker dialog
//            dpDialog = new DatePickerDialog(MainActivity.this, (view, year, month, dayOfMonth) -> {
//                myDay = dayOfMonth;
//                myMonth = month+1;
//                myYear = year;
//                Toast.makeText(MainActivity.this, "Date: " + myDay + "/" + myMonth + "/" + myYear, Toast.LENGTH_SHORT).show();
//            }, calendarYear, calendarMonth, calendarDay);
            //dpDialog.show();

//            tpDialog = new TimePickerDialog(MainActivity.this, (view, hourOfDay, minute) -> {
//                Toast.makeText(MainActivity.this, "Time: " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
//            }, calendarHour, calendarMinute, true);
//
//            tpDialog.show();



//class 10 first point
//            String dayOfWeek = "";
//            String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday",};
//
//
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//            String currentDateandTime = sdf.format(calendar.getTime());
//            tvOutput.setText(currentDateandTime);
            //tvOutput.setText(calendarDay +"(" + days[calenderDayOfWeek] + ")" + "/" + calendarMonth + "/" + calendarYear + " " + calendarHour + ":" + calendarMinute + ":" + calendarSecond);
        });


    }

}