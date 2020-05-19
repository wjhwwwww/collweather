package com.example.myweather.util;

import android.text.TextUtils;

import com.example.myweather.db.County;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CountyR {
    public static boolean  CountyRe(String s,int cityid){



        if(!TextUtils.isEmpty(s)){

            try {
                JSONArray jsonArray=new JSONArray(s);
                for (int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject= jsonArray.getJSONObject(i);
                    County county=new County();
                    county.setCountyCode(jsonObject.getInt("id"));
                    county.setCountyName(jsonObject.getString("name"));
                    county.setCityId(cityid);
                    county.save();


                }

  return  true;










            } catch (JSONException e) {
                e.printStackTrace();
            }


        }


return  false;


    }



}
