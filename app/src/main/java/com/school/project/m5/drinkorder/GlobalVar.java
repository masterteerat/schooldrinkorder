package com.school.project.m5.drinkorder;

import android.app.Application;
import android.content.Context;

public class GlobalVar extends Application {
/*
    public static String Base_Url = "http://192.168.1.202:8080";
*/
    public static String Base_Url = "http://temuscave.thddns.net:5355";
    public static String userName = "None";
    public static String userSID = "None";
    public static String userMID = "None";

    public static String result = "None";
    public static String status = "None";

    public static DataProdLine[] cart = new DataProdLine[10];
    public static Integer itemCountCart = 0;

    public static Context mainActivityContext;
}