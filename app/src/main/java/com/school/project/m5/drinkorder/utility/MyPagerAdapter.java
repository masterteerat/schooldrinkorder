package com.school.project.m5.drinkorder.utility;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.school.project.m5.drinkorder.fragment.TabAFragment;
import com.school.project.m5.drinkorder.fragment.TabBFragment;
import com.school.project.m5.drinkorder.fragment.TabCFragment;

public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private FragmentManager fragmentManager;
    private int anInt;

    public MyPagerAdapter(FragmentManager fragmentManager,
                          int anInt) {
        super(fragmentManager);
        this.fragmentManager = fragmentManager;
        this.anInt = anInt;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TabAFragment tabAFragment = new TabAFragment();
                return tabAFragment;
            case 1:
                TabBFragment tabBFragment = new TabBFragment();
                return tabBFragment;
            case 2:
                TabCFragment tabCFragment = new TabCFragment();
                return tabCFragment;
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return anInt;
    }
}
