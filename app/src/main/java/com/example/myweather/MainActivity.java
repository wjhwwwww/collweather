package com.example.myweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button in=(Button)findViewById(R.id.in);
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String address="http://guolin.tech/api/china";
                        OkHttpClient c=new OkHttpClient();
                        Request request=new Request.Builder()
                                .url(address)
                                .build();

                        try {
                            final Response response=c.newCall(request).execute();

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        Toast.makeText(MainActivity.this,"收到服务器："+response.body().string(),Toast.LENGTH_LONG).show();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        Toast.makeText(MainActivity.this,"response 问题",Toast.LENGTH_LONG).show();
                                    }


                                }
                            });




                        } catch (IOException e) {
                            e.printStackTrace();


                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(MainActivity.this,"URL 问题",Toast.LENGTH_LONG).show();


                                }
                            });







                        }



                    }
                }).start();










            }
        });




    }
}
