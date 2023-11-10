package com.joeun.dreamair.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

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
    private int[] pinTypes;
    private String passengerNo;
    private String passengerName;
    private String[] passengerNames;
    private String firstName;
    private String[] firstNames;
    private String lastName;
    private String[] lastNames;
    private String gender;
    private String[] genders;
    private String birth;
    private String[] births;
    private String phone;
    private String[] phones;
    private String email;
    private String[] emails;
    private String seatNoDep;       // 좌석번호(가는편)
    private String seatNoDes;       // 좌석번호(오는편)
    private int productNoDep;       // 상품번호(가는편)
    private int[] productNoDeps;       // 상품번호(가는편)
    private int productNoDes;       // 상품번호(오는편)
    private int[] productNoDess;       // 상품번호(오는편)
    private String password;
    private String[] passwords;

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

