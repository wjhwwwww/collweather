package com.example.myweather.db;
import org.litepal.crud.LitePalSupport;

public class Province extends LitePalSupport {

    private  int id;
    private  String provincename;
    private  int provincecode;


    public void setId(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }


    public void setProvincecode(int provincecode) {
        this.provincecode = provincecode;
    }

    public int getProvincecode() {
        return provincecode;
    }

    public void setProvincename(String provincename) {
        this.provincename = provincename;
    }


    public String getProvincename() {
        return provincename;
    }



}
