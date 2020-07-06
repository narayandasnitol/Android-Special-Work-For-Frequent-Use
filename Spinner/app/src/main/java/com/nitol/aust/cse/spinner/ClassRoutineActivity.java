package com.nitol.aust.cse.spinner;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ClassRoutineActivity extends AppCompatActivity {

    TextView yr, sem, sec, noRes, dept;
    DatabaseHelper myDb;
    ImageView routinePic;

    ClassRoutineHelper cR;
    Toolbar toolbar;

    String myDept;
    String myYear;
    String mySemester;
    String mySection;
    String myName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_routine);


        myDb = new DatabaseHelper(this);
        cR = new ClassRoutineHelper();


        yr = (TextView) findViewById(R.id.year_routine);
        sem = (TextView) findViewById(R.id.semester_routine);
        sec = (TextView) findViewById(R.id.section_routine);
        routinePic = (ImageView) findViewById(R.id.myRoutine);
        noRes = (TextView) findViewById(R.id.textView_no_result);
        dept = (TextView) findViewById(R.id.textView_dept);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getAllData();


    }

    public void getAllData(){

        Cursor result = myDb.getAllData();


        String student_department = "", student_year = "", student_semester = "",
                student_section = "", student_name ="";


        result.moveToFirst();
        while(!result.isAfterLast()){
            if (result.getString(result.getColumnIndex("DEPARTMENT")) != null){
                student_department += result.getString(result.getColumnIndex("DEPARTMENT"));
                student_department += "\n";
            }
            result.moveToNext();


            result.moveToFirst();
            if (result.getString(result.getColumnIndex("YEAR")) != null){
                student_year += result.getString(result.getColumnIndex("YEAR"));
                student_year += "\n";
            }
            result.moveToNext();


            result.moveToFirst();
            if (result.getString(result.getColumnIndex("SEMESTER")) != null){
                student_semester += result.getString(result.getColumnIndex("SEMESTER"));
                student_semester += "\n";
            }
            result.moveToNext();


            result.moveToFirst();
            if (result.getString(result.getColumnIndex("SECTION")) != null){
                student_section += result.getString(result.getColumnIndex("SECTION"));
                student_section += "\n";
            }
            result.moveToNext();

            result.moveToFirst();
            if (result.getString(result.getColumnIndex("NAME")) != null){
                student_name += result.getString(result.getColumnIndex("NAME"));
                student_name += "\n";
            }
            result.moveToNext();

        }

        myDept = student_department.trim();
        myYear = student_year.trim();
        mySemester = student_semester.trim();
        mySection = student_section.trim();
        myName = student_name.trim();

        yr.setText(myYear);
        sem.setText(mySemester);
        sec.setText(mySection);
        dept.setText(myDept);


        String routine = cR.getRoutine(myDept,myYear,mySemester,mySection);

        if(routine.trim().equals("cse_1_1_a")){
            routinePic.setImageResource(R.drawable.cse_1_1_a);
        }
        else if(routine.trim().equals("cse_1_1_b")){
            routinePic.setImageResource(R.drawable.cse_1_1_b);
        }
        else if(routine.trim().equals("cse_1_1_c")){
            routinePic.setImageResource(R.drawable.cse_1_1_c);
        }
        else if(routine.trim().equals("cse_1_2_a")){
            routinePic.setImageResource(R.drawable.cse_1_2_a);
        }
        else if(routine.trim().equals("cse_1_2_b")){
            routinePic.setImageResource(R.drawable.cse_1_2_b);
        }
        else if(routine.trim().equals("cse_2_1_a")){
            routinePic.setImageResource(R.drawable.cse_2_1_a);
        }
        else if(routine.trim().equals("cse_2_1_b")){
            routinePic.setImageResource(R.drawable.cse_2_1_b);
        }
        else if(routine.trim().equals("cse_2_1_c")){
            routinePic.setImageResource(R.drawable.cse_2_1_c);
        }
        else if(routine.trim().equals("cse_2_2_a")){
            routinePic.setImageResource(R.drawable.cse_2_2_a);
        }
        else if(routine.trim().equals("cse_2_2_b")){
            routinePic.setImageResource(R.drawable.cse_2_2_b);
        }
        else if(routine.trim().equals("cse_3_1_a")){
            routinePic.setImageResource(R.drawable.cse_3_1_a);
        }
        else if(routine.trim().equals("cse_3_1_b")){
            routinePic.setImageResource(R.drawable.cse_3_1_b);
        }
        else if(routine.trim().equals("cse_3_1_c")){
            routinePic.setImageResource(R.drawable.cse_3_1_c);
        }
        else if(routine.trim().equals("cse_3_2_a")){
            routinePic.setImageResource(R.drawable.cse_3_2_a);
        }
        else if(routine.trim().equals("cse_3_2_b")){
            routinePic.setImageResource(R.drawable.cse_3_2_b);
        }
        else if(routine.trim().equals("cse_4_1_a")){
            routinePic.setImageResource(R.drawable.cse_4_1_a);
        }
        else if(routine.trim().equals("cse_4_1_b")){
            routinePic.setImageResource(R.drawable.cse_4_1_b);
        }
        else if(routine.trim().equals("cse_4_1_c")){
            routinePic.setImageResource(R.drawable.cse_4_1_c);
        }
        else if(routine.trim().equals("cse_4_2_a")){
            routinePic.setImageResource(R.drawable.cse_4_2_a);
        }
        else if(routine.trim().equals("cse_4_2_b")){
            routinePic.setImageResource(R.drawable.cse_4_2_b);
        }
        else{
            noRes.setText("Nothing Found !");
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_tool,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.tool_settings){
            Intent intent = new Intent(ClassRoutineActivity.this, UpdateActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.tool_about){

            Toast.makeText(getApplicationContext(),"This is About !", Toast.LENGTH_SHORT).show();

        }
        else if ( id == android.R.id.home){

            finish();
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
