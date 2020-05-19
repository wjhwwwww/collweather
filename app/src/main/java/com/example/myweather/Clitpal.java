package com.example.myweather;

import android.app.Application;
import android.content.Context;

import org.litepal.LitePal;

public class Clitpal extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        Context context=getApplicationContext();
        LitePal.initialize(context);



    }











}
