package com.example.myweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherH {
    public  Aqi aqi;
    public  Basic basic;
    public  Now now;
    public  Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Daily> forecast;













}
