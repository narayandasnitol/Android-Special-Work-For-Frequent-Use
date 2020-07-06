package com.nitol.aust.cse.textfeild;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText username, password;
    RelativeLayout relativeLayout;
    TextInputLayout userLayout,passLayout;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (AppCompatEditText) findViewById(R.id.username_TextField);
        userLayout = (TextInputLayout) findViewById(R.id.username_TextInput_Layout);
        password = (AppCompatEditText) findViewById(R.id.password_TextField);
        passLayout = (TextInputLayout) findViewById(R.id.password_TextInput_Layout);
        btn = (Button) findViewById(R.id.button);

        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                if(username.getText().toString().isEmpty()){

                    userLayout.setErrorEnabled(true);
                    userLayout.setError("please enter your username!");

                }else{
                    userLayout.setErrorEnabled(false);
                }
            }
        });

        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(username.getText().toString().isEmpty()){

                    userLayout.setErrorEnabled(true);
                    userLayout.setError("please enter your username!");

                }else{
                    userLayout.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });

        passLayout.setCounterEnabled(true);
        userLayout.setCounterEnabled(true);
        passLayout.setCounterMaxLength(8);




    }
}
