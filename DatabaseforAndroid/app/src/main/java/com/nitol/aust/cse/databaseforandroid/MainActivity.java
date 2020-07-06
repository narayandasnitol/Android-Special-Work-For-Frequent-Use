package com.nitol.aust.cse.databaseforandroid;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editSurname, editMarks, editId;
    Button btnAddData, btnDeleteData, btnViewData, btnUpdateData;
    TextView showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);


        editName = (EditText) findViewById(R.id.name_id);
        editSurname = (EditText) findViewById(R.id.surname_id);
        editMarks = (EditText) findViewById(R.id.marks_id);
        editId = (EditText) findViewById(R.id.id_id);
        btnAddData = (Button) findViewById(R.id.addData);
        btnViewData = (Button) findViewById(R.id.viewData);
        btnDeleteData = (Button) findViewById(R.id.deleteData);
        btnUpdateData = (Button) findViewById(R.id.updateData);


        addData();
        viewAll();
        updateAll();
        deleteData();
    }

    public void addData(){

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean isInserted =  myDb.insertData(editName.getText().toString(),
                        editSurname.getText().toString(),editMarks.getText().toString());

                if(isInserted == true){
                    Toast.makeText(getApplicationContext(),"Data Inserted !", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Data not Inserted !", Toast.LENGTH_LONG).show();
                }
            }

        });
    }

    public void viewAll(){

        btnViewData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor result = myDb.getAllData();

                if(result.getCount() == 0){
                    //show message
                    showMessage("Error!", "Nothing found !");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(result.moveToNext()){
                    buffer.append("Id :"+result.getString(0)+"\n");
                    buffer.append("Name :"+result.getString(1)+"\n");
                    buffer.append("Surname :"+result.getString(2)+"\n");
                    buffer.append("Marks :"+result.getString(3)+"\n\n");
                }

                // show all data
                showMessage("Data",buffer.toString());
                //showData.setText(buffer.toString());
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

    public void updateAll(){
        btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = myDb.updateData(editId.getText().toString(),editName.getText().toString(),
                        editSurname.getText().toString(),editMarks.getText().toString());


                if(isUpdated == true) {
                    Toast.makeText(getApplicationContext(), "Data Updated !", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Data not Updated !", Toast.LENGTH_LONG).show();
                }

            }
        });
    }


    public void deleteData(){
        btnDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Integer deletedRow = myDb.deleteData(editId.getText().toString());

                if(deletedRow >0){
                    Toast.makeText(getApplicationContext(), "Data Deleted !", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Data not Deleted !", Toast.LENGTH_LONG).show();
                }

            }
        });
    }




}
