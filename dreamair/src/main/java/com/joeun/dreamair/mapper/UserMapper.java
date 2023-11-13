package com.joeun.dreamair.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.joeun.dreamair.dto.Auth;
import com.joeun.dreamair.dto.Users;

@Mapper
public interface UserMapper {


    // 회원 등록
    public int insertUsers(Users user) throws Exception;
    public int insertMileage(Users user) throws Exception;
    
    // 회원 조회
    public Users select(int userNo) throws Exception;

    // 회원 조회
    public Users selectById(String userId) throws Exception;

    // 비회원 조회
    public Users selectByUser2Id(String userId) throws Exception;
    
    // 회원 로그인 - id
    public Users login(String username);

    // 비회원
    public Users login2(String username);
 
    // 회원 권한 등록
    public int insertAuth(Auth auth) throws Exception;
    
    // 회원 수정
    public int update(Users user) throws Exception;

    // 회원 삭제
    public Users delete(String username);

    // 마일리지 조회
    public Users selectMileage(String username) throws Exception;


    
}
