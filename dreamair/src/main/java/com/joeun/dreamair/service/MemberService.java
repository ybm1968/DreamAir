package com.joeun.dreamair.service;

import javax.servlet.http.HttpServletRequest;

import com.joeun.dreamair.dto.Auth;
import com.joeun.dreamair.dto.Member;

public interface MemberService {

    // 로그인
    public void login(Member member, HttpServletRequest requset) throws Exception;

    public void login2(Member member, HttpServletRequest requset) throws Exception;

    public void admin_login(Member member, HttpServletRequest request) throws Exception;

    // 회원 권한 등록
    public int insertAuth(Auth auth) throws Exception;
}
