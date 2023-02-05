package com.school.project.m5.drinkorder;

import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;

public interface ApiRequests {

    @Headers("Content-Type: application/json")
    @POST("/api")
    Call<DataUserRet> postReq(@Body DataUserReq userData);

    @Headers("Content-Type: application/json")
    @POST("/api")
    Call<DataOrderRet> postOrderReq(@Body DataOrderReq orderData);

    @Headers("Content-Type: application/json")
    @POST("/api")
    Call<DataStatusRet> postStatusReq(@Body DataStatusReq statusData);
}