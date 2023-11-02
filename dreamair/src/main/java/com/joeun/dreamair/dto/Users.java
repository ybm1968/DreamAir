package com.joeun.dreamair.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Users {
    // users 테이블
    private int userNo;
    private String userId;
    private String userPw;
    private String userPwCheck;     // 비밀번호 확인
    private String name;
    private String address;
    private String phone;
    private String email;
    private Date regDate;
    private Date updDate;
    private String status;

    private int enabled;

    private List<Auth> authList;
    
    public Users(Users users) {
        this.userNo = users.getUserNo();
        this.userId = users.getUserId();
        this.userPw = users.getUserPw();
        this.name = users.getName();
        this.address = users.getAddress();
        this.phone = users.getPhone();
        this.email = users.getEmail();
        this.regDate = users.getRegDate();
        this.updDate = users.getUpdDate();
        this.status = users.getStatus();
        this.authList = users.getAuthList();
    }

    // user2 테이블
    private int userNo2;

    // auth 테이블
    private int authNo;
    private String auth;

    // passport 테이블
    private String passportNo;
    private int pinType;
    private String lastName;
    private String firstName;
    private String nationality;
    private String expirationDate;

    // PIN 테이블
    private String idCardNo;
    private String idDriverNo;

    // mileage 테이블
    private int mileage;

    // persistent_logins 테이블
    private int pNo;
    private String series; 
    private String token;
    private Date last_used;


}
    
  
   
