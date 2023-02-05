package com.school.project.m5.drinkorder;

import com.google.gson.annotations.SerializedName;

public class DataStatusReq {

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("mid")
    private String mid;
    @SerializedName("id")
    private String Id;

    public DataStatusReq() {
    }

    public DataStatusReq(String cmd, String mid, Integer Id) {
        this.mid = mid;
        this.cmd = cmd;
        this.Id = Id.toString();
    }

}
