package com.example.myweather.gson;

import com.google.gson.annotations.SerializedName;

public class Now {

    @SerializedName("tmp")
   public  String tmp;

    @SerializedName("cond")
    public  Cond cond;


    public class  Cond{

        @SerializedName("txt")
        public  String txt;


    }




}
