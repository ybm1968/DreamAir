package com.joeun.dreamair.dto;

import java.util.List;

import lombok.Data;

@Data
public class User2 {
    private int userNo2;
    private int authNo;     //(비회원한테는 어떤 권한이 필요하지?)
    private String phone;
    private String userPw;
    private String status;  
    
    private List<Auth> authList;    // 권한목록 추가??
}
