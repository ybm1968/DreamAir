package com.joeun.dreamair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Auth;
import com.joeun.dreamair.dto.Product;
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
    public Users deleteUsers(String username);

    // 마일리지 조회
    public Users selectMileage(String username) throws Exception;

    // 장바구니 조회 : 회원
    public List<Users> user_cart_list(int userNo) throws Exception;
    public List<Users> user2_cart_list(int userNo2) throws Exception;

    // 전체 탑승권 조회
    public List<Product> product_flightList() throws Exception;

    
    // 장바구니 조회 : 비회원
    public List<Users> user2_cart_list(int phone, int userPw) throws Exception;

    // 장바구니 추가
    public int cartadd(Users user) throws Exception;
    
    // 장바구니 삭제
    public int cart_delete(int userNo) throws Exception;

    // 회원 삭제 시, auth 테이블 삭제
    public Users deleteAuth(String username);
    
    // 회원 삭제 시, mileage 테이블 삭제
    public Users deleteMileage(String username);

}
