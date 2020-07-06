package com.nitol.aust.cse.recyclerview;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<DataModel> objectList;
    private LayoutInflater inflater;
    private Context context;

    public MyAdapter(Context context, List<DataModel> objectList){
        inflater = LayoutInflater.from(context);
        this.objectList = objectList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DataModel current = objectList.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {

        return objectList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private ImageView imgThumb, imgDelete, imgCopy;
        private int position;
        private DataModel currentObject;

        public MyViewHolder(View itemView){
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            imgThumb = (ImageView) itemView.findViewById(R.id.image1);
            imgDelete = (ImageView) itemView.findViewById(R.id.delete);
            imgCopy = (ImageView) itemView.findViewById(R.id.copy);

        }

        public void setData(DataModel currentObject, int position) {
            this.title.setText(currentObject.getTitle());
            this.imgThumb.setImageResource(currentObject.getImageID());
            this.position = position;
            this.currentObject = currentObject;
        }

        public void setListeners(){
            imgDelete.setOnClickListener(MyViewHolder.this);
            imgThumb.setOnClickListener(MyViewHolder.this);
            imgCopy.setOnClickListener(MyViewHolder.this);
        }

        @Override
        public void onClick(View v){
            switch (v.getId()){
                case R.id.delete:
                    removeItem(position);
                    break;

               case R.id.copy:
                    addItem(position, currentObject);
                    break;

                case R.id.title:
                    Toast.makeText(context, title.getText(), Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }

    public void removeItem(int position){
        objectList.remove(position);
        notifyItemRemoved(position);
          notifyItemRangeChanged(position, objectList.size());
          //notifyDataSetChanged();
    }

    public void addItem(int position, DataModel currentObject){
        objectList.add(position, currentObject);
        notifyItemInserted(position);
        notifyItemRangeChanged(position, objectList.size());
        //notifyDataSetChanged();

    }

    public MyAdapter(Context context){
        this.context=context;
    }
}
