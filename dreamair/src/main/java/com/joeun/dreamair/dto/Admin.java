package com.joeun.dreamair.dto;

import java.util.List;

import lombok.Data;

@Data
public class Admin {

    // admin 테이블
    private int adminNo;
    private String adminId;
    private String adminPw;
    private String adminPwCheck; // 암호화

    private List<Auth> authList;
    
    // public Admin(Admin admin) {
    //     this.adminNo = admin.getAdminNo();
    //     this.adminId = admin.getAdminId();
    //     this.adminPw = admin.getAdminPw();
    //     this.authList = admin.getAuthList();
    // }
    
    // auth 테이블
    private String userId;
    private int authNo;
    private String auth;


}
