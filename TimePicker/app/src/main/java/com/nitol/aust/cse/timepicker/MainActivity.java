package com.nitol.aust.cse.timepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TimePicker timePicker;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showTime();
    }

    public void showTime(){
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        btn = (Button) findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),timePicker.getCurrentHour() +" : "+timePicker.getCurrentMinute(),Toast.LENGTH_LONG).show();
            }
        });
    }


}
