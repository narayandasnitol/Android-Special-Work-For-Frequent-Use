package com.nitol.aust.cse.customalertwithradiobutton;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;


public class SingleChoiceClass extends DialogFragment{

    final CharSequence[] items = {"Easy", "Medium", "Hard"};
    String selection;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Chooce difficulty level").setSingleChoiceItems(items, -1,
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case 0:
                        selection = (String) items[which];

                        break;

                    case 1:
                        selection = (String) items[which];

                        break;

                    case 2:
                        selection = (String) items[which];

                        break;

                }
            }
        });


        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Your Difficulty level is "+selection,Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),"Sorry",Toast.LENGTH_SHORT).show();
            }
        });

        System.out.println(builder.create());

        return builder.create();
    }

}
