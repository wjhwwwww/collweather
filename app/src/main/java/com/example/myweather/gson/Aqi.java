package com.example.myweather.gson;

import com.google.gson.annotations.SerializedName;

public class Aqi {

    public City city;

    public  class City{

        @SerializedName("aqi")
        public  String aqi;

        @SerializedName("pm25")
        public  String pm25;



    }





}
