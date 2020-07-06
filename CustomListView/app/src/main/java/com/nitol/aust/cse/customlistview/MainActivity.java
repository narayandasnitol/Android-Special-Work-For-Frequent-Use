package com.nitol.aust.cse.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv =  (ListView) findViewById(R.id.custom_listView);

        String[] s1 = {"1", "2", "3", "4","5", "6", "7", "8"};
        String[] s2 = {"3","3", "3", "1.5", "0.75","3l", "1.5", "3" };
        String[] s3 = {"4", "4","3.75", "3.75", "3.50", "3.25","4", "4"};

        MyCustomListViewAdapter customAdapter = new MyCustomListViewAdapter(this, s1, s2, s3);
        lv.setAdapter(customAdapter);


    }
}
