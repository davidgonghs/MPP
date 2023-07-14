package com.posturedetection.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    Notification notification;
    Notification.Builder builder;
    NotificationManager notificationManager;
    NotificationChannel notificationChannel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notificationChannel = new NotificationChannel("myChannel", "myChannel", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
            builder = new Notification.Builder(getApplicationContext(), "myChannel");
        }else{
            builder = new Notification.Builder(getApplicationContext());
        }

        builder.setContentTitle("Posture Detection");
        builder.setContentText("Your posture is not correct");
        builder.setSmallIcon(R.drawable.ic_clock);
        notification = builder.build();
        notificationManager.notify(0, notification);
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 101, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        notification = builder.build();

        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(v -> {
            notificationManager.notify(101, notification);
        });

    }
}