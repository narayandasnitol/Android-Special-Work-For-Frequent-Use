package com.nitol.aust.cse.spinner;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class UpdateActivity extends AppCompatActivity {

    Button update_btn, cancel_btn, view_btn;
    DatabaseHelper myDb;
    Spinner department, year, semester, section;
    EditText eName;
    Toolbar toolbar;
    ProfileActivity pF;

    String myDept;
    String myYear;
    String mySemester;
    String mySection;
    String myName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        myDb = new DatabaseHelper(this);
        pF = new ProfileActivity();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        department = (Spinner) findViewById(R.id.department_spinner);
        year = (Spinner) findViewById(R.id.year_spinner);
        semester = (Spinner) findViewById(R.id.semester_spinner);
        section = (Spinner) findViewById(R.id.section_spinner);
        cancel_btn = (Button) findViewById(R.id.cancel_btn);
        update_btn = (Button) findViewById(R.id.update_btn);
        view_btn = (Button) findViewById(R.id.view_btn);
        eName = (EditText) findViewById(R.id.editText_name);

        updateAll();
        viewAll();
        getAllData();


    }

    public void getAllData() {

        Cursor result = myDb.getAllData();


        String student_department = "", student_year = "", student_semester = "",
                student_section = "", student_name = "";


        result.moveToFirst();
        while (!result.isAfterLast()) {

            if (result.getString(result.getColumnIndex("NAME")) != null) {
                student_name += result.getString(result.getColumnIndex("NAME"));
                student_name += "\n";
            }
            result.moveToNext();

            result.moveToFirst();
            if (result.getString(result.getColumnIndex("DEPARTMENT")) != null) {
                student_department += result.getString(result.getColumnIndex("DEPARTMENT"));
                student_department += "\n";
            }
            result.moveToNext();


            result.moveToFirst();
            if (result.getString(result.getColumnIndex("YEAR")) != null) {
                student_year += result.getString(result.getColumnIndex("YEAR"));
                student_year += "\n";
            }
            result.moveToNext();


            result.moveToFirst();
            if (result.getString(result.getColumnIndex("SEMESTER")) != null) {
                student_semester += result.getString(result.getColumnIndex("SEMESTER"));
                student_semester += "\n";
            }
            result.moveToNext();


            result.moveToFirst();
            if (result.getString(result.getColumnIndex("SECTION")) != null) {
                student_section += result.getString(result.getColumnIndex("SECTION"));
                student_section += "\n";
            }
            result.moveToNext();

        }

        myName = student_name.trim();
        myDept = student_department.trim();
        myYear = student_year.trim();
        mySemester = student_semester.trim();
        mySection = student_section.trim();

        eName.setText(myName);

    }

    public void updateAll(){
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = "1";
                String name = String.valueOf(eName.getText().toString());
                String dept = String.valueOf(department.getSelectedItem());
                String yr = String.valueOf(year.getSelectedItem());
                String sem = String.valueOf(semester.getSelectedItem());
                String sec = String.valueOf(section.getSelectedItem());



                boolean isUpdated = myDb.updateData(id, name, dept, yr, sem, sec);


                if(isUpdated == true) {
                    Toast.makeText(getApplicationContext(), "Data Updated !", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(UpdateActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Data not Updated !", Toast.LENGTH_SHORT).show();
                }

            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Data not Updated !", Toast.LENGTH_SHORT).show();

                Intent intent2 = new Intent(UpdateActivity.this, MenuActivity.class);
                startActivity(intent2);
            }
        });
    }


    public void viewAll(){

        view_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = myDb.getAllData();

                if(result.getCount() == 0){
                    showMessage("Error!", "Nothing found !");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while(result.moveToNext()){
                    buffer.append("NAME :"+result.getString(1)+"\n");
                    buffer.append("DEPARTMENT :"+result.getString(2)+"\n");
                    buffer.append("YEAR :"+result.getString(3)+"\n");
                    buffer.append("SEMESTER :"+result.getString(4)+"\n");
                    buffer.append("SECTION :"+result.getString(5)+"\n\n");

                }

                showMessage("Student's Information",buffer.toString());



            }
        });
    }

    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if ( id == android.R.id.home){

            Intent intent = new Intent(UpdateActivity.this, MenuActivity.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
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
