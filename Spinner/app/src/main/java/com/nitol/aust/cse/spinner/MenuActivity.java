package com.nitol.aust.cse.spinner;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView tv, header;
    ClassRoutineActivity cr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout) ;
        navigationView = (NavigationView) findViewById(R.id.navigation_view);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle
                (this,drawerLayout,toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }


    public void classRoutine(View view) {
        Intent intent = new Intent(MenuActivity.this, ClassRoutineActivity.class);
        startActivity(intent);
    }

    public void profile(View view){
        Intent intent = new Intent(MenuActivity.this, ProfileActivity.class);
        startActivity(intent);
    }

    public void cgpaCalculator(View view){
        Intent intent = new Intent(MenuActivity.this, CgpaCalculator.class);
        startActivity(intent);
    }

    public  void quizReminder(View view){
        Intent intent = new Intent(MenuActivity.this, QuizReminder.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

        else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){

            case R.id.routine:
                Intent intent = new Intent(MenuActivity.this, ClassRoutineActivity.class);
                startActivity(intent);

                break;

            case R.id.cgpa:
                Toast.makeText(getApplicationContext(),"CGPA Calculator",Toast.LENGTH_SHORT).show();

                break;

            case R.id.details:
                Toast.makeText(getApplicationContext(),"Class Details",Toast.LENGTH_SHORT).show();

                break;

            case R.id.quiz:
                Toast.makeText(getApplicationContext(),"Quiz Reminder",Toast.LENGTH_SHORT).show();

                break;

            case R.id.about:
                Toast.makeText(getApplicationContext(),"About",Toast.LENGTH_SHORT).show();

                break;

            case R.id.settings:
                Intent intent2 = new Intent(MenuActivity.this, UpdateActivity.class);
                startActivity(intent2);

                break;


        }

        drawerLayout.closeDrawer(GravityCompat.START);


        return true;
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
            Intent intent3 = new Intent(MenuActivity.this, UpdateActivity.class);
            startActivity(intent3);

        }
        else if(id == R.id.tool_about){

            Toast.makeText(getApplicationContext(),"This is About !", Toast.LENGTH_SHORT).show();

        }

        return super.onOptionsItemSelected(item);
    }

}

