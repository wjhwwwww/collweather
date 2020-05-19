package com.example.myweather.util;

import android.text.TextUtils;

import com.example.myweather.db.City;
import com.example.myweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProvinceR {
    public  static  boolean  Pr(String s){


        if(!TextUtils.isEmpty(s)){

            try {
                JSONArray jsonArray=new JSONArray(s);
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);
                 Province province=new Province();
                 province.setProvincecode(jsonObject.getInt("id"));
                 province.setProvincename(jsonObject.getString("name"));
                    province.save();
                }
        return true;



            } catch (JSONException e) {
                e.printStackTrace();
            }


        }





return false;

    }

}
