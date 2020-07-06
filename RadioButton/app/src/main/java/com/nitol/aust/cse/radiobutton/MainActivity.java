package com.nitol.aust.cse.radiobutton;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = (RadioGroup) findViewById(R.id.radioGroup);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int radioButtonId = rg.getCheckedRadioButtonId();
                rb = (RadioButton) findViewById(radioButtonId);
                System.out.println(rb.getText());
            }
        });
    }

    /*public void rbClick(View v){



        Toast.makeText(getBaseContext(),rb.getText(),Toast.LENGTH_SHORT).show();

    }*/
}
