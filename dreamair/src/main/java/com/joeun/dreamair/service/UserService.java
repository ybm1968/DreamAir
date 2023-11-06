package com.joeun.dreamair.service;

import javax.servlet.http.HttpServletRequest;

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

    // 회원 수정
    public int update(Users user) throws Exception;

    // 회원 삭제
    public Users delete(String userId) throws Exception;

    // 회원 마일리지 조회
    public Users selectMileage(String userId) throws Exception;

}
