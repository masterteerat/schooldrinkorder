package com.school.project.m5.drinkorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.school.project.m5.drinkorder.fragment.BaseFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentMainFragment, new BaseFragment())
                    .commit();
        }

        GlobalVar.mainActivityContext = MainActivity.this;
    }
}
