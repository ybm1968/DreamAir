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
    private int pasCount;
    private int roundTrip;
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
    private Date boarding;
    private Date departureTime;
    private Date destinationTime;
    private Date duration;
    private int checkedIn;
    private int isBoarded;

 
   
}

