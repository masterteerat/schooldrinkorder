package com.school.project.m5.drinkorder;

import com.google.gson.annotations.SerializedName;

public class DataUserReq {

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("mid")
    private String mid;
    @SerializedName("sid")
    private String sid;
    @SerializedName("name")
    private String name;

    public DataUserReq() {
    }

    public DataUserReq(String cmd, String mid, String sid, String name) {
        this.mid = mid;
        this.sid = sid;
        this.name = name;
        this.cmd = cmd;
    }

    public String getCommand() {
        return cmd;
    }

    public void setCommand(String cmd) {
        this.cmd = cmd;
    }

    public String getUsername() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
