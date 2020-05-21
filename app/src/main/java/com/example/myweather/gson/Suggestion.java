package com.example.myweather.gson;

import com.google.gson.annotations.SerializedName;

public class Suggestion {


    @SerializedName("cw")
    public Cw cw;
    @SerializedName("sport")
    public Sport sport;

    @SerializedName("comf")
    public  Comf comf;



    public  class  Cw{
    @SerializedName("txt")
        public String txt;

    }

    public  class Sport{


        @SerializedName("txt")
        public String txt;


    }



    public class  Comf{

        @SerializedName("txt")
        public String txt;
    }








}
