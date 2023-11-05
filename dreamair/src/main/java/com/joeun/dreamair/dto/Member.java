package com.joeun.dreamair.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Member {

    // admin 테이블
    private int adminNo;
    private String adminId;
    private String adminPw;
    private String adminPwCheck; // 암호화

    private List<Auth> authList;
    
    public Member() {
        
    }

    public Member(Admin admin) {
        this.adminNo = admin.getAdminNo();
        this.adminId = admin.getAdminId();
        this.adminPw = admin.getAdminPw();
        this.authList = admin.getAuthList();
    }
    
    // auth 테이블
    private String userId;
    private int authNo;
    private String auth;

     // users 테이블
     private int userNo; // 회원
     private int userNo2; // 비회원
    //  private String userId;
     private String userPw;
     private String userPwCheck;     // 비밀번호 확인
     private String name;
     private String address;
     private String phone;
     private String email;
     private Date regDate;
     private Date updDate;
     private String status;
 
     private int enabled;            // 휴면여부

     
     public Member(Users users) {
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
}
