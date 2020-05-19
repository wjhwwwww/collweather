package com.example.myweather;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myweather.db.City;
import com.example.myweather.db.County;
import com.example.myweather.db.Province;
import com.example.myweather.util.CityR;
import com.example.myweather.util.CountyR;
import com.example.myweather.util.ProvinceR;
import com.example.myweather.util.Util;

import org.litepal.crud.DataSupport;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ChooseF extends Fragment {


    public  static  int LevelP=0;
    public  static  int LevelCi=1;
    public  static  int LevelCo=2;
    private ProgressDialog progressDialog;
    private TextView title;
    private Button back;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private List<String> datalist=new ArrayList<>();
    private List<Province> provinceList;
    private  List<City> cityList;
    private  List<County> countyList;
    private  Province provinceselected;
    private   City citySelected;

    private  int currentLevel;









    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.choose,container,false);
        title=(TextView)view.findViewById(R.id.Title1);
        back=(Button)view.findViewById(R.id.back_in);
        listView=(ListView)view.findViewById(R.id.list);
        arrayAdapter=new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,datalist);
        listView.setAdapter(arrayAdapter);
        return  view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(currentLevel==LevelP){
                    provinceselected=provinceList.get(position);
                    queryCity();
                }else  if(currentLevel==LevelCi){

                    citySelected=cityList.get(position);
                    queryCounty();


                }



            }
        });





        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (currentLevel==LevelCo){

                    queryCity();

                }else if (currentLevel==LevelCi){

                    queryProvince();


                }



            }
        });




    }

    private void queryProvince() {

        title.setText("中国");
        back.setVisibility(View.GONE);
        provinceList= DataSupport.findAll(Province.class);
        if (provinceList.size()>0){

            datalist.clear();


    for (Province province : provinceList){

        datalist.add(province.getProvincename());

            }

            arrayAdapter.notifyDataSetChanged();
            listView.setSelection(0);
            currentLevel=LevelP;




        }else {

            String address="http://guolin.tech/api/china";
            queryFromService(address,"Province");



        }







    }

    private void queryFromService(String address, final String type) {

        showdialog();
        Util.sendHttp(address, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {


                        closeDialog();
                        Toast.makeText(getContext(),"加载失败",Toast.LENGTH_LONG).show();

                    }
                });




            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String res=response.body().string();
                boolean result=false;
                if ("province".equals(type)){

                    result= ProvinceR.Pr(res);


                }else if ("City".equals(type)){

                    result= CityR.CityRe(res,provinceselected.getId());

                }else if ("County".equals(type)){
                    result= CountyR.CountyRe(res,citySelected.getId());

                }

                if (result){

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {


                            closeDialog();
                            if ("Province".equals(type)){
                                queryProvince();
                            }else if ("City".equals(type)){
                                queryCity();
                            }else if ("County".equals(type)){

                                queryCounty();


                            }



                        }
                    });


                }








            }
        });











    }

    private void closeDialog() {
        if (progressDialog!=null){

            progressDialog.dismiss();


        }


    }

    private void showdialog() {


        if (progressDialog==null){

            progressDialog=new ProgressDialog(getContext());
            progressDialog.setMessage("加载中。。。。。");
            progressDialog.setCanceledOnTouchOutside(false);

        }
        progressDialog.show();


    }

    private void queryCity() {

title.setText(provinceselected.getProvincename());
back.setVisibility(View.VISIBLE);
cityList=DataSupport.where("provinceId = ?",String.valueOf(provinceselected.getId())).find(City.class);
if (cityList.size()>0){
    datalist.clear();
    for (City city : cityList){
        datalist.add(city.getCityName());
    }
    arrayAdapter.notifyDataSetChanged();
    listView.setSelection(0);
    currentLevel=LevelCi;

}else {
    int provinceC=provinceselected.getProvincecode();
    String address="http://guolin.tech/api/china/"+provinceC;
    queryFromService(address,"City");

}









    }

    private void queryCounty() {



title.setText(citySelected.getCityName());
back.setVisibility(View.VISIBLE);
countyList=DataSupport.where("cityId = ?",String.valueOf(citySelected.getId())).find(County.class);
if (countyList.size()>0){
    datalist.clear();
    for (County county :countyList){

        datalist.add(county.getCountyName());

    }
    arrayAdapter.notifyDataSetChanged();
    listView.setSelection(0);
    currentLevel=LevelCo;



}else {

    int provinceC=provinceselected.getProvincecode();
    int cityC=citySelected.getCityCode();
    String address="http://guolin.tech/api/china/"+provinceC+"/"+cityC;
    queryFromService(address,"County");


}














    }
}
