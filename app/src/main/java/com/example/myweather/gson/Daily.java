package com.example.myweather.gson;

import com.google.gson.annotations.SerializedName;

public class Daily {


        @SerializedName("date")
        public  String  date;
        @SerializedName("cond")
        public  Cond cond;
        @SerializedName("tmp")
        public  Tmp tmp;



        public  class Cond{
            @SerializedName("txt_d")
            public  String txt;
        }

        public  class  Tmp{
            @SerializedName("max")
            public String max;
            @SerializedName("min")
            public String min;



        }






}
