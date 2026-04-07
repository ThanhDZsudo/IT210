package com.example.session02.model;

import java.util.Date;

public class Order {
    private String id;
    private String productName;
    private double total;
    private Date date;

    public Order(String id, String productName, double total, Date date) {
        this.id = id;
        this.productName = productName;
        this.total = total;
        this.date = date;
    }

    public String getId() { return id; }
    public String getProductName() { return productName; }
    public double getTotal() { return total; }
    public Date getDate() { return date; }
}