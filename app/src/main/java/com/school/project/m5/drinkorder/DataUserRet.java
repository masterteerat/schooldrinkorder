package com.school.project.m5.drinkorder;

import com.google.gson.annotations.SerializedName;

public class DataUserRet {

    @SerializedName("status")
    private String status;
    @SerializedName("name")
    private String name;
    @SerializedName("sid")
    private String sid;

    public DataUserRet() {}

    public DataUserRet(String status,String name,String sid) {

        this.status = status;
        this.name = name;
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }


}

