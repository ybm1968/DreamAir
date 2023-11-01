package com.joeun.dreamair.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Users;

@Service
public interface UserService {

  // 사용자 로그인
    public void login(Users user, HttpServletRequest request) throws Exception;
    
    public void login2(Users user, HttpServletRequest request) throws Exception;


}
