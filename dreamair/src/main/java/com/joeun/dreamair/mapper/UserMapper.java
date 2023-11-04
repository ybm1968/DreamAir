package com.joeun.dreamair.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Auth;
import com.joeun.dreamair.dto.Users;

@Mapper
public interface UserMapper {

    // 회원 등록
    public int insert(Users user) throws Exception;
    
    // 회원 조회
    public Users select(int userNo) throws Exception;

    // 회원 조회
    public Users selectById(String userId) throws Exception;
    
    // 회원 로그인 - id
    public Users login(String username);

    // 비회원
    public Users login2(String username);

    // 회원 권한 등록
    public int insertAuth(Auth auth) throws Exception;
    
    // 회원 수정
    public int update(Users user) throws Exception;
    
    // public void login(Users user, HttpServletRequest request) throws Exception;
      
    // public void login2(Users user, HttpServletRequest request) throws Exception;
    
    // public int insertAuth(Auth userAuth) throws Exception;

    // 마일리지 등록
    public int latedUserNo() throws Exception;
    
    public int mileageInsert(int userNo) throws Exception;

}
