package com.joeun.dreamair.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Admin {

    // admin 테이블
    private int adminNo;
    private String adminId;
    private String adminPw;

    private List<Auth> authList;    

    // auth 테이블
    private String userId;
    private String auth;

    // flight 테이블
    private int flightNo;
    private String flightName;
    private int routeNo;
    private int seatMax;
    private int seatRemaining;
    private int seatUsed;

    // 파일 등록
    private List<MultipartFile> file;

}
