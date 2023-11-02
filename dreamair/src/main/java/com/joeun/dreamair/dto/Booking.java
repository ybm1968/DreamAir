package com.joeun.dreamair.dto;

import java.util.Date;

import lombok.Data;

@Data
public class Booking {
    // booking 테이블
    private int bookingNo;
    private String name;
    private String seatNo;
    private int userNo;
    private int userNo2;
    private int productNo;
    private int routeNo;
    private int pasCount;       // 탑승 인원
    private int roundTrip;      // 왕복 여부
    private String status;

    // passengers 테이블
    private int pinType;
    private String passengerNo;
    private String passengerName;
    private String firstName;
    private String lastName;
    private String gender;
    private String birth;
    private String phone;
    private String email;

    // cart
    private int cartNo;
    private int cartCnt;

    // ticket 테이블
    private int ticketNo;
    private String departure;           // 출발지
    private String destination;         // 도착지
    private String boarding;            // 탑승시간(수정함)
    private String departureTime;         // 출발 시간(수정함)
    private String destinationTime;       // 도착 시간(수정함)
    private String duration;            // 소요시간(수정함)
    private int checkedIn;
    private int isBoarded;

    // product 테이블
    // private int productNo;
    // private int routeNo;
    // private String name;
    // private String productCat;
    private int productPrice;
    // private String departure;
    // private String destination;
    // private Date productRegDate;
    // private Date productUpdDate;

    // flight 테이블
    private int flightNo;
    private String flightName;
    // private String seatNo;
    // private int routeNo;
    // private int seatMax;
    private int seatRemaining;
    // private int seatUsed;


   
}

