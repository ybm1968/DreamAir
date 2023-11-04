package com.joeun.dreamair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.Users;

@Mapper
public interface AdminMapper {
    
   /**
     * 관리자
     */
    // 관리자 로그인
    // public void admin_login(Admin admin) throws Exception;

    // 관리자  인증(로그인) - id
    public Admin admin_login(String username);

    // 관리자 권한 등록
    // public int insertAuth(Auth adminAuth) throws Exception;

    // 관리자 로그인(id, pw)
    // public Admin admin_login(String adminId, String adminPw) throws Exception;
    //public Admin admin_login( String adminId, String adminPw) throws Exception;

    // 관리자 등록
    public int admin_insert(Admin admin) throws Exception;

    
    /**
     * 사용자 관리
     */
    // 전체 사용자 조회
    public List<Users> user_list() throws Exception;

    // 사용자 수동 등록
    public int user_insert(Users users) throws Exception;
    
    // 사용자 정보 수정
    public int user_update(int userNo) throws Exception;

    // 사용자 정보 삭제
    public int user_delete(int userNo) throws Exception;

    /**
     * 예매 관리
     */
    // 전체 예매 내역 조회
    public List<Admin> booking_list() throws Exception;

    /**
     * 탑승권 관리
     */
    // 탑승권 조회 : 항공기 번호를 입력 했을 때 당일에 한하여만 조회 가능, 체크인도 되어 있어야 함
    public Users ticket_select(int ticketNo) throws Exception;

    // 탑승권 목록 내역 조회(전체)
    public List<Admin> ticket_list() throws Exception;

    // 탑승 처리 : (탑승완료1, 미탑승0)
    public int ticket_used(int ticketNo) throws Exception;
}
