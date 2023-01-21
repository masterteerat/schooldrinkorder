package com.school.project.m5.drinkorder;

import static java.security.AccessController.getContext;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.provider.Settings.Secure;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        String android_id = android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        checkUser(android_id);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (GlobalVar.status == "yes") {
                    Intent intent = new Intent(splashscreen.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(splashscreen.this, Registerscreen.class);
                    startActivity(intent);
                }
            }
        }, 3000);



    }
    void checkUser(String DeviceId) {

        Retrofit api = new Retrofit.Builder()
                .baseUrl("http://192.168.1.202:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiRequests service = api.create(ApiRequests.class);
        Call<com.school.project.m5.drinkorder.DataUserRet> call = service.postReq(new DataUserReq("checkuser",DeviceId,"none","none"));

        call.enqueue(new Callback<com.school.project.m5.drinkorder.DataUserRet>() {

            @Override
            public void onResponse(Call<com.school.project.m5.drinkorder.DataUserRet> call, Response<com.school.project.m5.drinkorder.DataUserRet> response) {
                com.school.project.m5.drinkorder.DataUserRet response1 = response.body();

                GlobalVar.status = response1.getStatus();
            }

            @Override
            public void onFailure(Call<com.school.project.m5.drinkorder.DataUserRet> call, Throwable t) {
                Log.d("artoy", t.toString());
            }
        });

    }






}