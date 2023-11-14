package com.joeun.dreamair.service;

import java.util.List;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.dto.Users;

public interface UserService {

    // 회원 등록
    public int insert(Users user) throws Exception;

    // 회원 조회
    public Users select(int userNo) throws Exception;

    // 회원 조회 - id
    public Users selectById(String userId) throws Exception;

    // 회원 조회 - id
    public Users selectById2(Principal principal) throws Exception;

    // 로그인
    public void login(Users user, HttpServletRequest requset) throws Exception;

    // 회원 수정
    public int update(Users user) throws Exception;

    // 회원 삭제
    public Users delete(String userId) throws Exception;

    // 회원 마일리지 조회
    public Users selectMileage(String userId) throws Exception;

    // 장바구니 조회 : 회원
    public List<Users> user_cart_list(int userNo) throws Exception;
    
    // 장바구니 조회 : 비회원
    public List<Users> user2_cart_list(int phone, int userPw) throws Exception;

    // 장바구니 추가
    public int cartadd(Users user) throws Exception;
    
    // 장바구니 삭제
    public int cart_delete(int userNo) throws Exception;

    // 전체 탑승권 조회
    public List<Product> product_flightList() throws Exception;
}
