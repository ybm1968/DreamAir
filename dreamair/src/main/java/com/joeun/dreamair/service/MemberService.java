package com.joeun.dreamair.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.joeun.dreamair.dto.Member;

public interface MemberService {

    // 로그인
    public void login(Member member, HttpServletRequest requset) throws Exception;

    public void login2(Member member, HttpServletRequest requset) throws Exception;

    public void admin_login(Member member, HttpServletRequest request) throws Exception;

    // 회원 권한 등록
    // public int insertAuth(Auth auth) throws Exception;

    // 사용자 목록 조회
    public List<Member> user_list() throws Exception;

    // // 사용자 수동 등록
    // public int user_insert(Member users) throws Exception;

    // // 사용자 정보 수정
    // public int user_update(int userNo) throws Exception;

    // // 사용자 정보 삭제
    // public int user_delete(int userNo) throws Exception;
    
    // // 관리자 목록 조회
    // public List<Member> admin_list() throws Exception;

    // // 관리자 정보 수정
    // public int admin_update(int adminNo) throws Exception;

    // // 관리자 정보 삭제
    // public int admin_delete(int adminNo) throws Exception;
}
