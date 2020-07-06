package com.nitol.aust.cse.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,0);

                Notification notification = new Notification.Builder(MainActivity.this)
                        .setTicker("Ticker Title")
                        .setContentTitle("Content Title")
                        .setContentText("This is content text")
                        .setSmallIcon(R.drawable.ic_launcher)
                        .setContentIntent(pendingIntent).getNotification();

                notification.flags = notification.FLAG_AUTO_CANCEL;
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0,notification);


            }
        });


    }
}
