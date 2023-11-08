package com.joeun.dreamair.dto;

import lombok.Data;

@Data
public class ProductIo {

    // private String name;
    // private String productCat;
    // private int productPrice;
    // private String departure;
    // private String destination;
    // private Date productRegdate;
    // private Date productUpdate;

    // 상품 입출고 테이블
    private int ioNo;
    private int productNo;
    private int routeNo;
    private int bookingNo;
    private int amount;
    private String type;
    
}
