package com.joeun.dreamair.mapper;

import java.util.List;

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

    // 사용자 목록 조회
    public List<Member> user_list() throws Exception;

    // 사용자 수동 등록
    public int user_insert(Member users) throws Exception;

    // 사용자 정보 수정
    public int user_update(int userNo) throws Exception;

    // 사용자 정보 삭제
    public int user_delete(int userNo) throws Exception;

    // 관리자 목록 조회
    public List<Member> admin_list() throws Exception;

    // 관리자 정보 수정
    public int admin_update(int adminNo) throws Exception;

    // 관리자 정보 삭제
    public int admin_delete(int adminNo) throws Exception;
}
