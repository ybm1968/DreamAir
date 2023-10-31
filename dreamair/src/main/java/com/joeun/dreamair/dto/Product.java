package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Product {
    private int productNo;
    private int routeNo;
    private String name;
    private String productCat;
    private int productPrice;
    private String departure;
    private String destination;
    private Date productRegDate;
    private Date productUpdDate;
}
