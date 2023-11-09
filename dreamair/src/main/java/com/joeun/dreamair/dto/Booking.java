package com.joeun.dreamair.dto;

import java.util.ArrayList;

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
    private String productId;
    private int pasCount;       // 탑승 인원
    private String roundTrip;      // 왕복 여부
    private String status;
    private String regDate;
    private String upDate;
    private String ticketType;

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
    private String seatNoDep;       // 좌석번호(가는편)
    private String seatNoDes;       // 좌석번호(오는편)
    private String productIdDep;    // 상품코드(가는편)
    private String productIdDes;    // 상품코드(오는편)
    private int productNoDep;       // 상품번호(가는편)
    private int productNoDes;       // 상품번호(오는편)

    private ArrayList<Booking> bookingList;

    // cart
    private int cartNo;
    private int cartCnt;

    // ticket 테이블
    private int ticketNo;
    private String departure;           // 출발지
    private String destination;         // 도착지
    private String boarding;            // 탑승시간
    private String departureTime;         // 출발 시간
    private String destinationTime;       // 도착 시간
    private String departureDate;         // 출발 날짜
    private String destinationDate;       // 도착 날짜
    private String duration;            // 소요시간
    private int checkedIn;
    private int isBoarded;
    private String boardingTime;          // 실제 탑승시간

    // product 테이블
    private int productPrice;

    // flight 테이블
    private int flightNo;
    private String flightName;
    private int seatRemaining;
    // private int seatUsed;

    // 탑승권 처리 할 때 필요한 변수
    private int select;
}

