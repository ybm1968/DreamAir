package com.joeun.dreamair.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
public class Booking {

    // booking 테이블
    private int bookingNo;
    private int bookingNo2;
    private String name;
    private String[] names;
    private String seatNo;
    private int userNo;
    private int[] userNos;
    private int userNo2;
    private int[] userNos2;
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
    private int passengerNo;
    private int[] passengerNos;
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
    private String[] seatNoDepss;       // 좌석번호(가는편)
    private String seatNoDes;       // 좌석번호(오는편)
    private String[] seatNoDesss;       // 좌석번호(오는편)
    private int productNoDep;       // 상품번호(가는편)
    private int[] productNoDeps;       // 상품번호(가는편)
    private int productNoDes;       // 상품번호(오는편)
    private int[] productNoDess;       // 상품번호(오는편)
    private String productIdDep;
    private String[] productIdDeps;
    private String productIdDes;
    private String[] productIdDess;
    private String userPw;
    private String[] userPws;
    private int routeNoDep;         // 노선번호(가는편)
    private int[] routeNoDeps;         // 노선번호(가는편)
    private int routeNoDes;         // 노선번호(오는편)
    private int[] routeNoDess;         // 노선번호(오는편)

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

    // 예매 리스트 확인 시 필요한 변수
    private String userId;

    private List<String> passengerNoss;  // info에서 탑승객 정보 DB 등록된 후에 탑승객 번호 조회
    private List<String> seatNoDeps;    // 좌석 번호 가는 편
    private List<String> seatNoDess;    // 좌석 번호 오는 편


}

