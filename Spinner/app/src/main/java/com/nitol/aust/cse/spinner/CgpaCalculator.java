package com.nitol.aust.cse.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CgpaCalculator extends AppCompatActivity {
    ListView lv;
    Toolbar toolbar;
    Button add_btn;
    TextView serial, credit, gpa, total, final_cgpa;
    EditText credit_in, gpa_in;
    int add_click = 1;
    double cI = 0, tG = 0;
    String my_grade;
    int posi;

    ArrayList<String> a = new ArrayList<>();
    ArrayList<String> b = new ArrayList<>();
    ArrayList<String> c = new ArrayList<>();
    ArrayList<String> d = new ArrayList<>();

    ArrayList<String> arrayList = new ArrayList<>();
    ArrayList<String> arrayList2 = new ArrayList<>();
    ArrayList<String> arrayList3 = new ArrayList<>();
    ArrayList<String> arrayList4 = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa_calculator);

        lv = (ListView) findViewById(R.id.id_listView);
        add_btn = (Button) findViewById(R.id.id_add_btn);
        credit_in = (EditText) findViewById(R.id.id_credit_input);
        gpa_in = (EditText) findViewById(R.id.id_gpa_input);
        serial = (TextView) findViewById(R.id.textView_1);
        credit = (TextView) findViewById(R.id.textView_2);
        gpa = (TextView) findViewById(R.id.textView_3);
        total = (TextView) findViewById(R.id.textView_4);
        final_cgpa = (TextView) findViewById(R.id.final_cgpa);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        addResult();

    }


    public void addResult(){

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String s = credit_in.getText().toString().trim();
                String ss = gpa_in.getText().toString().trim();

                if(s.length() == 0 || ss.length() == 0){
                    Toast.makeText(getApplicationContext(), "please fill all the information!", Toast.LENGTH_SHORT).show();

                }

                else{

                    DecimalFormat dF = new DecimalFormat("#.000");

                    double creditInput = Double.parseDouble(credit_in.getText().toString());
                    cI += creditInput;


                    double gpaInput = Double.parseDouble(gpa_in.getText().toString());

                    if(gpaInput == 4.0){
                        my_grade = "A+";
                    }
                    else if(gpaInput == 3.75){
                        my_grade = "A";
                    }
                    else if(gpaInput == 3.5){
                        my_grade = "A-";
                    }
                    else if(gpaInput == 3.25){
                        my_grade = "B+";
                    }
                    else if(gpaInput == 3.0){
                        my_grade = "B";
                    }
                    else if(gpaInput == 2.75){
                        my_grade = "B-";
                    }
                    else if(gpaInput == 2.5){
                        my_grade = "C+";
                    }
                    else if(gpaInput == 2.25){
                        my_grade = "C";
                    }
                    else if(gpaInput == 2.0){
                        my_grade = "D";
                    }
                    else{
                        my_grade = "F";
                    }

                    if(gpaInput >4){
                        Toast.makeText(getApplicationContext(), "GPA can't be more than 4!!!",
                                Toast.LENGTH_SHORT).show();
                        gpa_in.setText("");
                    }
                    else{

                        double total_gpa = creditInput * gpaInput;
                        tG += total_gpa;

                        Double formattedValue = Double.valueOf(dF.format(tG / cI));
                        String finalCGPA = "CGPA = "+Double.toString(formattedValue);

                        if(finalCGPA.length() == 10)
                            finalCGPA = "CGPA = "+Double.toString(formattedValue)+"0";

                        final_cgpa.setText(finalCGPA);
                        gpa_in.setText("");


                        String my_id = Integer.toString(add_click);

                        String my_credit = Double.toString(creditInput);
                        if(my_credit.trim().length() == 3)
                            my_credit = Double.toString(creditInput)+"0";


                        String my_gpa = Double.toString(gpaInput);
                        if(my_gpa.trim().length() == 3)
                            my_gpa = Double.toString(gpaInput)+"0";



                        arrayList.add(my_id);
                        arrayList2.add(my_credit);
                        arrayList3.add(my_gpa);
                        arrayList4.add(my_grade);

                        MyCustomListViewAdapter customAdapter = new MyCustomListViewAdapter(CgpaCalculator.this,
                                arrayList, arrayList2, arrayList3, arrayList4);
                        customAdapter.notifyDataSetChanged();
                        lv.setAdapter(customAdapter);


                        Toast.makeText(getApplicationContext(),"Input Successful!", Toast.LENGTH_SHORT).show();
                        add_click++;
                    }

                }

            }
        });

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
            Intent intent = new Intent(CgpaCalculator.this, UpdateActivity.class);
            startActivity(intent);

        }
        else if(id == R.id.tool_about){

            Toast.makeText(getApplicationContext(),"This is About !", Toast.LENGTH_SHORT).show();

        }
        else if ( id == android.R.id.home){

            Intent intent = new Intent(CgpaCalculator.this, MenuActivity.class);
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
