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
    private String roundTrip;      // 왕복 여부(수정함)
    private String status;
    private String regDate;
    private String updDate;

    // passengers 테이블
    private int pinType;
    private int passengerNo;
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
    private String boardingTime;    // 실제 탑승 시간
    private String departureDate;
    private String destinationDate;

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


    // 왕복 변수 정리
    /*
     * 필요한 변수
     * 가는날 오는날
     * 가는날 : 출발시간(가는날 날짜 + 출발시간) 도착시간(가는날 날짜 + 도착시간)
     * 오는날 : 출발시간(오는날짜 + 출발시간) 도착시간(오는날짜 + 도착시간) null 허용
     * 추가할 테이블 : ticket, route v
     * 돌아오는날 데이터 들어가는 행에있는 출발지 도착지는 반대로 값을 넣어야함
     */

     
    private String userId;
    private String password;
   
}

