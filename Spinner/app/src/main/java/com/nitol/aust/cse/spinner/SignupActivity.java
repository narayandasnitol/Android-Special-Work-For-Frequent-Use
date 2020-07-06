package com.nitol.aust.cse.spinner;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class SignupActivity extends AppCompatActivity {

    Spinner department, year, semester, section;
    EditText eName;
    Button cancel, signup, view;
    DatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        myDb = new DatabaseHelper(this);

        department = (Spinner) findViewById(R.id.department_spinner);
        year = (Spinner) findViewById(R.id.year_spinner);
        semester = (Spinner) findViewById(R.id.semester_spinner);
        section = (Spinner) findViewById(R.id.section_spinner);
        cancel = (Button) findViewById(R.id.cancel_btn);
        signup = (Button) findViewById(R.id.update_btn);
        eName = (EditText) findViewById(R.id.editText_name);


        Cursor result = myDb.getAllData();

        if(result.getCount() >= 1){
            Intent intent = new Intent(SignupActivity.this, MenuActivity.class);
            startActivity(intent);
        }

        else{
            saveData();
        }


    }

    public void saveData(){
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = String.valueOf(eName.getText().toString());
                String dept = String.valueOf(department.getSelectedItem());
                String yr = String.valueOf(year.getSelectedItem());
                String sem = String.valueOf(semester.getSelectedItem());
                String sec = String.valueOf(section.getSelectedItem());


                myDb.insertData(name, dept, yr, sem, sec);

                Intent intent = new Intent(SignupActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        this.finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }



}
