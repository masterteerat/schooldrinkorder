package com.school.project.m5.drinkorder;

import com.google.gson.annotations.SerializedName;

public class DataOrderRet {

    @SerializedName("status")
    private String status;


    public DataOrderRet() {}

    public DataOrderRet(String status) {

        this.status = status;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
