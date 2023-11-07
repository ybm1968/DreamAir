package com.joeun.dreamair.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Admin {

    // admin 테이블
    private int adminNo;
    private int authNo;
    private String adminId;
    private String adminPw;

    private List<Auth> authList;    

    // auth 테이블
    private String userId;
    private String auth;

    // flight 테이블
    private int flightNo;
    private String flightName;
    private String seatNo;
    private int seatMax;
    private int seatRemaining;
    private int seatUsed;
}
