package com.nitol.aust.cse.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.id_listView);

        final String[] name1 = {"Nitol", "Tumpa", "Niloy", "Deboshree", "Nirjon", "Nishan"};
        final String[] name2 = {"Nitol", "Tumpa", "Niloy", "Deboshree", "Nirjon", "Nishan"};



        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.lv_layout, R.id.id_text, name1);
        adapter.notifyDataSetChanged();
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Clicked on "+ name1[position], Toast.LENGTH_SHORT).show();
            }
        });


    }
}
