package com.school.project.m5.drinkorder;

public class DataProdLine {

    public String prodId;
    public int imgResId;
    public String description;
    public Integer quantity;
    public Double price;
    public Double totalPrice;
    public String status;
    public String recId;
    public String name;

    public DataProdLine() {

    }

    public DataProdLine(String prodId, int imgResId, String description, Integer quantity, Double price, Double totalPrice, String status) {
        this.prodId = prodId;
        this.imgResId = imgResId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.status = status;
        this.recId = "";
        this.name = "";
    }

    public void updateDataProdLine(String prodId, int imgResId, String description, Integer quantity, Double price, Double totalPrice, String status) {
        this.prodId = prodId;
        this.imgResId = imgResId;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.status = status;
        this.recId = "";
        this.name = "";
    }
}
