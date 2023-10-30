package com.joeun.dreamair.dto;

import java.util.List;

import lombok.Data;

@Data
public class Admin {
    private int adminNo;
    private int authNo;
    private String adminId;
    private String adminPw;

    private List<Auth> authList;    // 권한목록 추가??
}
