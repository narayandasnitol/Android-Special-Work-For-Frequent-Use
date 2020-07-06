package com.nitol.aust.cse.myalarmclock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // for Alarm 25/12/2012 at 12.00
        Calendar myAlarmDate = Calendar.getInstance();
        myAlarmDate.setTimeInMillis(System.currentTimeMillis());
        myAlarmDate.set(2012, 11, 25, 12, 00, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        Intent _myIntent = new Intent(context, AlarmReceiverNotificationForEveryMonth.class);
        _myIntent.putExtra("MyMessage","HERE I AM PASSING THEPERTICULAR MESSAGE WHICH SHOULD BE SHOW ON RECEIVER OF ALARM");
        PendingIntent _myPendingIntent = PendingIntent.getBroadcast(context, 123, _myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, myAlarmDate.getTimeInMillis(),_myPendingIntent);
    }
}
