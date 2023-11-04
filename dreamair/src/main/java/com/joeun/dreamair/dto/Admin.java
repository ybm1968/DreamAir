package com.joeun.dreamair.dto;

import java.util.Date;
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

        // users 테이블
    private int userNo;
    // private String userId;
    private String userPw;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Date regDate;
    private Date updDate;
    private String status;

      // file 테이블
      private int fileNo;
      private String parentTable;
      private int parentNo;
      private String fileName;
      private String originName;
      private String filePath;
      private int fileSize;
      private int fileCode;


}
