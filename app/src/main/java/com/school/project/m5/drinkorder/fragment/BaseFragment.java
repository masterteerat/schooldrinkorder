package com.school.project.m5.drinkorder.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.school.project.m5.drinkorder.ApiRequests;
import com.school.project.m5.drinkorder.DataOrderReq;
import com.school.project.m5.drinkorder.DataOrderRet;
import com.school.project.m5.drinkorder.DataStatusReq;
import com.school.project.m5.drinkorder.DataStatusRet;
import com.school.project.m5.drinkorder.GlobalVar;
import com.school.project.m5.drinkorder.R;
import com.school.project.m5.drinkorder.utility.MyPagerAdapter;

import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseFragment extends Fragment{

    private Timer myTimer;
    private Timer statusCheckTimer;
    private Timer statusGetTimer;
    private ImageButton imgBtnSubmit;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView txtName;
    private TextView txtSid;
    private Integer Idex;
    Context mContext;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create TabLayout
        createTabLayout();

//        Create ViewPager
        createViewPager();

    }   // Main Method

    private void createViewPager() {
        txtName = getView().findViewById(R.id.txtName);
        txtSid = getView().findViewById(R.id.txtSid);
        txtName.setText("ชื่อ: " + GlobalVar.userName);
        txtSid.setText("รหัสนักเรียน: " + GlobalVar.userSID);
        this.mContext = GlobalVar.mainActivityContext;
        imgBtnSubmit = getView().findViewById(R.id.imgBtnUpload);

        statusCheckTimer = new Timer();
        statusCheckTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                timerCheckStatus();
            }

        }, 500, 5000);

        imgBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)  {
                if (GlobalVar.itemCountCart == 0) {
                    showWarnDialog();
                }else {
                    showConfirmDialog("สั่งเครื่องดื่ม?:");
                }
            }
        });

        viewPager = getView().findViewById(R.id.viewPager);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(
                getActivity().getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(myPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition()==1) {
                    GlobalVar.cartAdapter.upDateCartDataChange();
                }
                else if (tab.getPosition()==2) {
                    GlobalVar.orderedAdapter.upDateOrderedDataChange();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if (tab.getPosition()==1) {
                    GlobalVar.cartAdapter.upDateCartDataChange();
                }
                else if (tab.getPosition()==2) {
                    GlobalVar.orderedAdapter.upDateOrderedDataChange();
                }
            }
        });

    }

    public void timerCheckStatus() {
        Idex = 0;
        GlobalVar.result = "stop";
        statusGetTimer = new Timer();
        statusGetTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                timerGetStatus();
            }

        }, 0, 100);
    }

    public void timerGetStatus() {
        if (GlobalVar.result.equals("stop")) {
            GlobalVar.result = "wait";
            statusGet(Idex);
        }
        else if (GlobalVar.result.equals("yes")) {
            Idex = Idex + 1;
            if (Idex < GlobalVar.ordered.length) {
                GlobalVar.result = "wait";
                statusGet(Idex);
            } else {
                statusGetTimer.cancel();
            }
        }
        else if (GlobalVar.result.equals("no")) {
            statusGetTimer.cancel();
        }
    }

    public void timerCheck() {

        if (!GlobalVar.status.equals("wait")) {
            if (GlobalVar.status.equals("yes")) {
                initDataset();

            }

            myTimer.cancel();

        }
    }

    public void showConfirmDialog(String intPuttxt) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setMessage(intPuttxt + "ยืนยันการสั่งเครื่องดื่ม");

        builder.setPositiveButton("ยืนยัน", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                myTimer = new Timer();
                myTimer.schedule(new TimerTask() {

                    @Override
                    public void run() {
                        timerCheck();
                    }

                }, 500, 500);

                GlobalVar.status = "wait";

                orderPord();
                dialog.dismiss();
                tabLayout.getTabAt(0).select();
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

    public void showWarnDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setMessage("ไม่สามารถสั่งได้: ไม่มีสินค้าในตระกร้าของคุณ");

        builder.setNegativeButton("ตกลง", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.dismiss();
            }
        });
        builder.show();
    }

    void orderPord() {

        Retrofit api = new Retrofit.Builder()

                .baseUrl(GlobalVar.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiRequests service = api.create(ApiRequests.class);
        Call<DataOrderRet> call = service.postOrderReq(new DataOrderReq(GlobalVar.userMID, "order", GlobalVar.userName, GlobalVar.cart));

        call.enqueue(new Callback<DataOrderRet>() {

            @Override
            public void onResponse(Call<com.school.project.m5.drinkorder.DataOrderRet> call, Response<DataOrderRet> response) {
                com.school.project.m5.drinkorder.DataOrderRet response1 = response.body();

                GlobalVar.status = response1.getStatus();

            }

            @Override
            public void onFailure(Call<com.school.project.m5.drinkorder.DataOrderRet> call, Throwable t) {

                Log.d("artoy", t.toString());

            }
        });

    }

    void statusGet(Integer Id) {

        Retrofit api = new Retrofit.Builder()

                .baseUrl(GlobalVar.Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiRequests service = api.create(ApiRequests.class);
        Call<DataStatusRet> call = service.postStatusReq(new DataStatusReq("checkorder", GlobalVar.userMID, Id));

        call.enqueue(new Callback<DataStatusRet>() {

            @Override
            public void onResponse(Call<com.school.project.m5.drinkorder.DataStatusRet> call, Response<DataStatusRet> response) {
                com.school.project.m5.drinkorder.DataStatusRet response1 = response.body();

                GlobalVar.result = response1.getStatus();
                GlobalVar.ordered[Id].prodId = response1.getProdId();
                GlobalVar.ordered[Id].recId = response1.getRecId();
                GlobalVar.ordered[Id].description = response1.getDescription();
                GlobalVar.ordered[Id].imgResId = response1.getImgResId();
                GlobalVar.ordered[Id].totalPrice = response1.getTotalPrice();
                GlobalVar.ordered[Id].status = response1.getProdStatus();
                GlobalVar.ordered[Id].quantity = response1.getQuantity();
                GlobalVar.itemCountOrdered = Id+1;
            }

            @Override
            public void onFailure(Call<com.school.project.m5.drinkorder.DataStatusRet> call, Throwable t) {

                Log.d("artoy", t.toString());

            }
        });

    }

    private void createTabLayout() {
        tabLayout = getView().findViewById(R.id.tabLayout);
        String[] strings = new String[]{"เมนู", "ตระกร้า", "สถานะ"};
        for (int i=0; i<strings.length; i+=1) {
            tabLayout.addTab(tabLayout.newTab().setText(strings[i]));
        }
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        return view;
    }

    private void initDataset() {

        GlobalVar.itemCountCart = 0;
        GlobalVar.cart[0].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        GlobalVar.cart[1].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        GlobalVar.cart[2].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        GlobalVar.cart[3].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        GlobalVar.cart[4].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        GlobalVar.cart[5].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        GlobalVar.cart[6].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        GlobalVar.cart[7].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        GlobalVar.cart[8].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");
        GlobalVar.cart[9].updateDataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "enqueue");

    }
}
