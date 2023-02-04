package com.school.project.m5.drinkorder;

import com.google.gson.annotations.SerializedName;

public class DataOrderReq {

    @SerializedName("cmd")
    private String cmd;
    @SerializedName("mid")
    private String mid;
    @SerializedName("name")
    private String name;

    @SerializedName("prodid0")
    private String prodid0;
    @SerializedName("imgresid0")
    private String imgresid0;
    @SerializedName("description0")
    private String description0;
    @SerializedName("quantity0")
    private String quantity0;
    @SerializedName("price0")
    private String price0;
    @SerializedName("totalprice0")
    private String totalprice0;
    @SerializedName("prodstatus0")
    private String status0;

    @SerializedName("prodid1")
    private String prodid1;
    @SerializedName("imgresid1")
    private String imgresid1;
    @SerializedName("description1")
    private String description1;
    @SerializedName("quantity1")
    private String quantity1;
    @SerializedName("price1")
    private String price1;
    @SerializedName("totalprice1")
    private String totalprice1;
    @SerializedName("prodstatus1")
    private String status1;

    @SerializedName("prodid2")
    private String prodid2;
    @SerializedName("imgresid2")
    private String imgresid2;
    @SerializedName("description2")
    private String description2;
    @SerializedName("quantity2")
    private String quantity2;
    @SerializedName("price2")
    private String price2;
    @SerializedName("totalprice2")
    private String totalprice2;
    @SerializedName("prodstatus2")
    private String status2;

    @SerializedName("prodid3")
    private String prodid3;
    @SerializedName("imgresid3")
    private String imgresid3;
    @SerializedName("description3")
    private String description3;
    @SerializedName("quantity3")
    private String quantity3;
    @SerializedName("price3")
    private String price3;
    @SerializedName("totalprice3")
    private String totalprice3;
    @SerializedName("prodstatus3")
    private String status3;

    @SerializedName("prodid4")
    private String prodid4;
    @SerializedName("imgresid4")
    private String imgresid4;
    @SerializedName("description4")
    private String description4;
    @SerializedName("quantity4")
    private String quantity4;
    @SerializedName("price4")
    private String price4;
    @SerializedName("totalprice4")
    private String totalprice4;
    @SerializedName("prodstatus4")
    private String status4;

    @SerializedName("prodid5")
    private String prodid5;
    @SerializedName("imgresid5")
    private String imgresid5;
    @SerializedName("description5")
    private String description5;
    @SerializedName("quantity5")
    private String quantity5;
    @SerializedName("price5")
    private String price5;
    @SerializedName("totalprice5")
    private String totalprice5;
    @SerializedName("prodstatus5")
    private String status5;

    @SerializedName("prodid6")
    private String prodid6;
    @SerializedName("imgresid6")
    private String imgresid6;
    @SerializedName("description6")
    private String description6;
    @SerializedName("quantity6")
    private String quantity6;
    @SerializedName("price6")
    private String price6;
    @SerializedName("totalprice6")
    private String totalprice6;
    @SerializedName("prodstatus6")
    private String status6;

    @SerializedName("prodid7")
    private String prodid7;
    @SerializedName("imgresid7")
    private String imgresid7;
    @SerializedName("description7")
    private String description7;
    @SerializedName("quantity7")
    private String quantity7;
    @SerializedName("price7")
    private String price7;
    @SerializedName("totalprice7")
    private String totalprice7;
    @SerializedName("prodstatus7")
    private String status7;

    @SerializedName("prodid8")
    private String prodid8;
    @SerializedName("imgresid8")
    private String imgresid8;
    @SerializedName("description8")
    private String description8;
    @SerializedName("quantity8")
    private String quantity8;
    @SerializedName("price8")
    private String price8;
    @SerializedName("totalprice8")
    private String totalprice8;
    @SerializedName("prodstatus8")
    private String status8;

    @SerializedName("prodid9")
    private String prodid9;
    @SerializedName("imgresid9")
    private String imgresid9;
    @SerializedName("description9")
    private String description9;
    @SerializedName("quantity9")
    private String quantity9;
    @SerializedName("price9")
    private String price9;
    @SerializedName("totalprice9")
    private String totalprice9;
    @SerializedName("prodstatus9")
    private String status9;

    public DataOrderReq() {
    }

    public DataOrderReq(String mid, String cmd, String name, DataProdLine[] DataOrderCart) {
        this.mid = mid;
        this.name = name;
        this.cmd = cmd;

        this.prodid0 = DataOrderCart[0].prodId;
        this.imgresid0 = Integer.toString(DataOrderCart[0].imgResId);
        this.description0 = DataOrderCart[0].description;
        this.quantity0 = DataOrderCart[0].quantity.toString();
        this.price0 = DataOrderCart[0].price.toString();
        this.totalprice0 = DataOrderCart[0].totalPrice.toString();
        this.status0 = DataOrderCart[0].status;

        this.prodid1 = DataOrderCart[1].prodId;
        this.imgresid1 = Integer.toString(DataOrderCart[1].imgResId);
        this.description1 = DataOrderCart[1].description;
        this.quantity1 = DataOrderCart[1].quantity.toString();
        this.price1 = DataOrderCart[1].price.toString();
        this.totalprice1 = DataOrderCart[1].totalPrice.toString();
        this.status1 = DataOrderCart[1].status;

        this.prodid2 = DataOrderCart[2].prodId;
        this.imgresid2 = Integer.toString(DataOrderCart[2].imgResId);
        this.description2 = DataOrderCart[2].description;
        this.quantity2 = DataOrderCart[2].quantity.toString();
        this.price2 = DataOrderCart[2].price.toString();
        this.totalprice2 = DataOrderCart[2].totalPrice.toString();
        this.status2 = DataOrderCart[2].status;

        this.prodid3 = DataOrderCart[3].prodId;
        this.imgresid3 = Integer.toString(DataOrderCart[3].imgResId);
        this.description3 = DataOrderCart[3].description;
        this.quantity3 = DataOrderCart[3].quantity.toString();
        this.price3 = DataOrderCart[3].price.toString();
        this.totalprice3 = DataOrderCart[3].totalPrice.toString();
        this.status3 = DataOrderCart[3].status;

        this.prodid4 = DataOrderCart[4].prodId;
        this.imgresid4 = Integer.toString(DataOrderCart[4].imgResId);
        this.description4 = DataOrderCart[4].description;
        this.quantity4 = DataOrderCart[4].quantity.toString();
        this.price4 = DataOrderCart[4].price.toString();
        this.totalprice4 = DataOrderCart[4].totalPrice.toString();
        this.status4 = DataOrderCart[4].status;

        this.prodid5 = DataOrderCart[5].prodId;
        this.imgresid5 = Integer.toString(DataOrderCart[5].imgResId);
        this.description5 = DataOrderCart[5].description;
        this.quantity5 = DataOrderCart[5].quantity.toString();
        this.price5 = DataOrderCart[5].price.toString();
        this.totalprice5 = DataOrderCart[5].totalPrice.toString();
        this.status5 = DataOrderCart[5].status;

        this.prodid6 = DataOrderCart[6].prodId;
        this.imgresid6 = Integer.toString(DataOrderCart[6].imgResId);
        this.description6 = DataOrderCart[6].description;
        this.quantity6 = DataOrderCart[6].quantity.toString();
        this.price6 = DataOrderCart[6].price.toString();
        this.totalprice6 = DataOrderCart[6].totalPrice.toString();
        this.status6 = DataOrderCart[6].status;

        this.prodid7 = DataOrderCart[7].prodId;
        this.imgresid7 = Integer.toString(DataOrderCart[7].imgResId);
        this.description7 = DataOrderCart[7].description;
        this.quantity7 = DataOrderCart[7].quantity.toString();
        this.price7 = DataOrderCart[7].price.toString();
        this.totalprice7 = DataOrderCart[7].totalPrice.toString();
        this.status7 = DataOrderCart[7].status;

        this.prodid8 = DataOrderCart[8].prodId;
        this.imgresid8 = Integer.toString(DataOrderCart[8].imgResId);
        this.description8 = DataOrderCart[8].description;
        this.quantity8 = DataOrderCart[8].quantity.toString();
        this.price8 = DataOrderCart[8].price.toString();
        this.totalprice8 = DataOrderCart[8].totalPrice.toString();
        this.status8 = DataOrderCart[8].status;

        this.prodid9 = DataOrderCart[9].prodId;
        this.imgresid9 = Integer.toString(DataOrderCart[9].imgResId);
        this.description9 = DataOrderCart[9].description;
        this.quantity9 = DataOrderCart[9].quantity.toString();
        this.price9 = DataOrderCart[9].price.toString();
        this.totalprice9 = DataOrderCart[9].totalPrice.toString();
        this.status9 = DataOrderCart[9].status;


    }

}

