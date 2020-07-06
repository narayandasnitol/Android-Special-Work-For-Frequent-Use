package com.nitol.aust.cse.customalertdialogue;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button btnShow, btnLogin;
    EditText email , pass;
    RadioGroup rg;
    RadioButton rb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = (Button) findViewById(R.id.btnShowDialog);


        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new  AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.radio_department, null);

                /*final EditText mEmail = (EditText) mView.findViewById(R.id.email);
                final EditText mPassword = (EditText) mView.findViewById(R.id.password);
                Button mLogin = (Button) mView.findViewById(R.id.btnLogin);*/

                /*mLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty())
                            Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                        else
                            Toast.makeText(getApplicationContext(),"Please fill any empty fields !", Toast.LENGTH_SHORT).show();
                    }
                });*/

                rg = (RadioGroup) mView.findViewById(R.id.radioGroup);

                rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                        int radioButtonId = rg.getCheckedRadioButtonId();
                        rb = (RadioButton) findViewById(radioButtonId);
                        System.out.println(rb.getText());
                    }
                });



                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
    }
}
