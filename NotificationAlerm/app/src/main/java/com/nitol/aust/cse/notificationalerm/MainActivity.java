package com.nitol.aust.cse.notificationalerm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn, dlt;
    AlarmManager alarmManager;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        dlt = (Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                java.util.Calendar calendar = java.util.Calendar.getInstance();

                calendar.set(Calendar.HOUR_OF_DAY, 1);
                calendar.set(Calendar.MINUTE, 36);
                calendar.set(Calendar.SECOND, 0);
                calendar.set(Calendar.YEAR, 2017);
                calendar.set(Calendar.MONTH, 6);
                calendar.set(Calendar.DAY_OF_MONTH, 25);



                intent = new Intent(getApplicationContext(), NotificationReceiver.class);
                intent.putExtra("requestCode", 123);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 123, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);



            }
        });

        dlt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PendingIntent displayIntent = PendingIntent.getBroadcast(MainActivity.this,
                        100, intent, PendingIntent.FLAG_NO_CREATE);

                if(displayIntent != null) {
                    alarmManager.cancel(displayIntent);
                    displayIntent.cancel();
                }
            }
        });
    }


}
