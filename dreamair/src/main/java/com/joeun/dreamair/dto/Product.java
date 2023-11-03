package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Product {

    // product 테이블
    private int productNo;
    private int routeNo;
    private String name;
    private String productCat;
    private int productPrice;
    private String departure;
    private String destination;
    private Date productRegDate;
    private Date productUpdDate;

    // seat 테이블
    private String seatNo;
    private int bookingNo;
    private String passengerName;
    private int flightNo;
    private String seatClass;

    // flight 테이블
    // private int flightNo;
    private String flightName;

    // private String seatNo;
    private int seatMax;
    private int seatRemaining;
    private int seatUsed;

    // cart 테이블
    private int cartNo;
    private int userNo;
    private int userNo2;
    private int cartCnt;

    // route    
    // private int routeNo;    
    // private String departure;     
    // private String destination;
    private Date departureTime;     
    private Date destinationTime;

}
