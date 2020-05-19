package com.example.myweather.db;

import org.litepal.crud.DataSupport;

public class County extends DataSupport {


    private  int id;
    private int cityId;
    private  String countyName;
    private  int countyCode;
    private  String weatherId;
    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }


    public String getWeatherId() {
        return weatherId;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyName() {
        return countyName;
    }


    public void setCountyCode(int countyCode) {
        this.countyCode = countyCode;
    }

    public int getCountyCode() {
        return countyCode;
    }
}
