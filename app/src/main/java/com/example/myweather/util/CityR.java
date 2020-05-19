package com.example.myweather.util;

import android.text.TextUtils;

import com.example.myweather.db.City;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CityR {



    public  static boolean CityRe(String s,int pid){

        if(!TextUtils.isEmpty(s)){

            try {
                JSONArray jsonArray=new JSONArray(s);
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);
                    City city=new City();
                    city.setCityCode(jsonObject.getInt("id"));
                    city.setCityName(jsonObject.getString("name"));
                    city.setProvinceId(pid);
                    city.save();

                }
return  true;











            } catch (JSONException e) {
                e.printStackTrace();
            }


        }




return false;

    }





}
