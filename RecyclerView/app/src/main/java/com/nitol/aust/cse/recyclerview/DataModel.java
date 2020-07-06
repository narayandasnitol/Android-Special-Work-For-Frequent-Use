package com.nitol.aust.cse.recyclerview;


import java.util.ArrayList;
import java.util.List;

public class DataModel {

    private int imageID;
    private String title;

    public int getImageID(){
        return imageID;
    }

    public void setImageID(int imageID){
        this.imageID = imageID;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public static List<DataModel> getObjectList(){

        List<DataModel> dataList = new ArrayList<>();
        int[] images = getImages();

        for(int i=0; i<images.length; i++){
            DataModel data = new DataModel();
            data.setImageID(images[i]);
            data.setTitle("Picture "+i);
            dataList.add(data);
        }
        return dataList;
    }

    private static int[] getImages(){

        int[] images = {R.drawable.alarm, R.drawable.alarm,
                R.drawable.alarm, R.drawable.alarm, R.drawable.alarm,R.drawable.alarm, R.drawable.alarm,
                R.drawable.alarm, R.drawable.alarm, R.drawable.alarm,R.drawable.alarm, R.drawable.alarm,
                R.drawable.alarm, R.drawable.alarm, R.drawable.alarm,R.drawable.alarm, R.drawable.alarm,
                R.drawable.alarm, R.drawable.alarm, R.drawable.alarm,R.drawable.alarm, R.drawable.alarm,
                R.drawable.alarm, R.drawable.alarm, R.drawable.alarm,R.drawable.alarm, R.drawable.alarm,
                R.drawable.alarm, R.drawable.alarm, R.drawable.alarm};

        return images;
    }
}

