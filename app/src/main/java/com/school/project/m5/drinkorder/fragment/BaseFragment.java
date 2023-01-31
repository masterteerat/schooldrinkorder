package com.school.project.m5.drinkorder.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.school.project.m5.drinkorder.GlobalVar;
import com.school.project.m5.drinkorder.R;
import com.school.project.m5.drinkorder.utility.MyPagerAdapter;

public class BaseFragment extends Fragment{

    private ImageButton imgBtnSubmit;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TextView txtName;
    private TextView txtSid;
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
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void showConfirmDialog(String intPuttxt) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

        builder.setMessage(intPuttxt + "ยืนยันการสั่งเครื่องดื่ม");

        builder.setPositiveButton("ยืนยัน", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


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
}
