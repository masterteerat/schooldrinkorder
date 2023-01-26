package com.school.project.m5.drinkorder.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.school.project.m5.drinkorder.R;
import com.school.project.m5.drinkorder.utility.MyPagerAdapter;

public class BaseFragment extends Fragment{

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Create TabLayout
        createTabLayout();

//        Create ViewPager
        createViewPager();

    }   // Main Method

    private void createViewPager() {
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
