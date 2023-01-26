package com.school.project.m5.drinkorder;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Registerscreen extends AppCompatActivity {

    private EditText etxtName;
    private EditText etxtSid;
    private Button btnRet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerscreen);

        etxtName = findViewById(R.id.name);
        etxtSid = findViewById(R.id.sid);
        btnRet = findViewById(R.id.button);

        btnRet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog("ยืนยันลงทะเบียน?");
            }
        });



    }

    public void showDialog(final String inpTxt) {
        AlertDialog.Builder builder = new AlertDialog.Builder(Registerscreen.this);

        builder.setMessage("ลงทะเบียน: " + inpTxt);

        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){

                String Name = etxtName.getText().toString();
                String Sid = etxtSid.getText().toString();
                registerUser(GlobalVar.userMID, Sid, Name);

                Intent intent = new Intent(Registerscreen.this,splashscreen.class);
                finish();
                startActivity(intent);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("ยกเลิก", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();
            }
        });
        builder.show();
    }

    void registerUser(String DeviceId, String Sid, String Name) {

        Retrofit api = new Retrofit.Builder()
                .baseUrl("http://192.168.1.202:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiRequests service = api.create(ApiRequests.class);
        Call<DataUserRet> call = service.postReq(new DataUserReq("register",DeviceId,Sid,Name));

        call.enqueue(new Callback<DataUserRet>() {

            @Override
            public void onResponse(Call<com.school.project.m5.drinkorder.DataUserRet> call, Response<DataUserRet> response) {
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