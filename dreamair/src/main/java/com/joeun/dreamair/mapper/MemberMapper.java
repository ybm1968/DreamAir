package com.joeun.dreamair.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Auth;
import com.joeun.dreamair.dto.Member;

@Mapper
public interface MemberMapper {

    // 관리자  인증(로그인) - id
    public Member admin_login(String username);

    // 회원 로그인 - id
    public Member login(String username);

    // 비회원
    public Member login2(String username);

    // 회원 권한 등록
    public int insertAuth(Auth auth) throws Exception;
}
