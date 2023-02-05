package com.school.project.m5.drinkorder;

import com.google.gson.annotations.SerializedName;

public class DataStatusRet {

    @SerializedName("status")
    private String status;
    @SerializedName("recid")
    private String recId;
    @SerializedName("name")
    private String name;
    @SerializedName("prodid")
    private String prodId;
    @SerializedName("imgresid")
    private String imgresId;
    @SerializedName("description")
    private String description;
    @SerializedName("quantity")
    private String quantity;
    @SerializedName("price")
    private String price;
    @SerializedName("totalprice")
    private String totalprice;
    @SerializedName("prodstatus")
    private String prodStatus;



    public DataStatusRet() {

        this.status = "";
        this.recId = "";
        this.name = "";
        this.prodId = "";
        this.imgresId = "";
        this.description = "";
        this.quantity = "";
        this.price = "";
        this.totalprice = "";
        this.prodStatus = "";

    }

    public String getStatus() {
        return status;
    }

    public String getRecId() { return recId; }

    public String getName() { return name; }

    public String getProdId() { return prodId; }

    public int getImgResId() { return Integer.valueOf(imgresId); }

    public String getDescription() { return description; }

    public Integer getQuantity() { return Integer.valueOf(quantity); }

    public Double getPrice() { return Double.valueOf(price); }

    public Double getTotalPrice() { return Double.valueOf(totalprice); }

    public String getProdStatus() { return prodStatus; }

}