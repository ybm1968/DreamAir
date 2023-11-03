package com.joeun.dreamair.service;

import javax.servlet.http.HttpServletRequest;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.Users;

public interface UserService {

    // 회원 등록
    public int insert(Users user) throws Exception;

    // 회원 조회
    public Users select(int userNo) throws Exception;

    // 회원 조회 - id
    public Users selectById(String userId) throws Exception;

    // 로그인
    public void login(Users user, HttpServletRequest requset) throws Exception;

    // 관리자
    // public Users admin_login(String userId) throws Exception;
    public void admin_login(Admin admin, HttpServletRequest request) throws Exception;
    
    // 회원 수정
    public int update(Users user) throws Exception;

    // public void login2(Users user, HttpServletRequest request) throws Exception;

}