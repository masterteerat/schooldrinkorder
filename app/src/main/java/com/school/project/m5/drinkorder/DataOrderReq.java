package com.school.project.m5.drinkorder;

import com.google.gson.annotations.SerializedName;

public class DataOrderReq {

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("mid")
    private String mid;
    @SerializedName("name")
    private String name;
    @SerializedName("prodid")
    private String prodid;
    @SerializedName("imgresid")
    private String imgresid;
    @SerializedName("description")
    private String description;
    @SerializedName("quantity")
    private String quantity;
    @SerializedName("price")
    private String price;
    @SerializedName("totalprice")
    private String totalprice;
    @SerializedName("prodstatus")
    private String status;


    public DataOrderReq() {
    }

    public DataOrderReq(String mid, String cmd, String name, DataProdLine[] DataOrderCart) {
        this.mid = mid;
        this.name = name;
        this.cmd = cmd;

        this.prodid = DataOrderCart[0].prodId;
        this.imgresid = Integer.toString(DataOrderCart[0].imgResId);
        this.description = DataOrderCart[0].description;
        this.quantity = DataOrderCart[0].quantity.toString();
        this.price = DataOrderCart[0].price.toString();
        this.totalprice = DataOrderCart[0].totalPrice.toString();
        this.status = DataOrderCart[0].status;


    }

}

