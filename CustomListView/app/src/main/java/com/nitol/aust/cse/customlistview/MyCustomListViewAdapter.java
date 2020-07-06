package com.nitol.aust.cse.customlistview;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyCustomListViewAdapter extends BaseAdapter{

    String[] text1, text2, text3;
    Context context;
    private static LayoutInflater  inflater = null;

    public MyCustomListViewAdapter(MainActivity mainAct, String[] name1, String[] name2, String[] name3){
        text1 = name1;
        text2 = name2;
        text3 = name3;

        context = mainAct;

        inflater = (LayoutInflater)  context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return text1.length;
    }

    @Override
    public Object getItem(int position) {

        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyHolder{
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        System.out.println("Position = "+position);

        MyHolder myHolder = new MyHolder();
        View myView;

        myView = inflater.inflate(R.layout.custom_layout, null);

        myHolder.tv1 = (TextView) myView.findViewById(R.id.textView_1);
        myHolder.tv2 = (TextView) myView.findViewById(R.id.textView_2);
        myHolder.tv3 = (TextView) myView.findViewById(R.id.textView_3);

        myHolder.tv1.setText(text1[position]);
        myHolder.tv2.setText(text2[position]);
        myHolder.tv3.setText(text3[position]);


        myView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"This is "+ text1[position],Toast.LENGTH_SHORT).show();
                Toast.makeText(context,"This is "+ text2[position],Toast.LENGTH_SHORT).show();
                Toast.makeText(context,"This is "+ text3[position],Toast.LENGTH_SHORT).show();
            }
        });


        return myView;
    }
}
