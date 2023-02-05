package com.school.project.m5.drinkorder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.window.SplashScreen;

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
        initDataCart();
        initDataOrder();
    }

    /*@Override
    protected void onResume() {
        Intent intent = new Intent(MainActivity.this, splashscreen.class);
        finish();
        MainActivity.this.startActivity(intent);
        super.onResume();
    }*/

    private void initDataCart() {

        GlobalVar.cart[0] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        GlobalVar.cart[1] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        GlobalVar.cart[2] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        GlobalVar.cart[3] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        GlobalVar.cart[4] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        GlobalVar.cart[5] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        GlobalVar.cart[6] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        GlobalVar.cart[7] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        GlobalVar.cart[8] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        GlobalVar.cart[9] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");

    }

    private void initDataOrder() {
        for (int i = 0; i < GlobalVar.ordered.length; i++) {
            GlobalVar.ordered[i] = new DataProdLine("0", R.drawable.school_logo, "", 0, 0.0, 0.0, "");
        }
    }
}
