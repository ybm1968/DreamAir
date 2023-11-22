package com.joeun.dreamair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.Auth;
import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.dto.Users;

@Mapper
public interface AdminMapper {
    
   /**
     * 관리자
     */
    // 전체 관리자 조회
    public List<Admin> admin_list() throws Exception;

    // 관리자 등록
    public int admin_insert(Admin admin) throws Exception;
    
    // 회원 권한 등록
    public int insertAuth(Auth auth) throws Exception;

    // 사용자 정보 삭제
    public int admin_delete(int adminNo) throws Exception;

    // 회원 권한 삭제
    public int deleteAuth(Auth auth) throws Exception;
    
    // /**
    //  * 사용자 관리
    //  */
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
    public List<Booking> booking_list() throws Exception;

    /**
     * 탑승권 관리
     */
    // 탑승권 조회 : 항공기 번호를 입력 했을 때 당일에 한하여만 조회 가능, 체크인도 되어 있어야 함
    public List<Booking> ticket_selectList(@Param("today") String today
                                         , @Param("flightNo")  int flightNo
                                         , @Param("checkedIn")  int checkedIn
                                         , @Param("isBoarded")  int isBoarded) throws Exception;

    public List<Booking> ticket_selectList_w(@Param("today") String tody, @Param("flightNo") int flightNo) throws Exception;

    // 탑승권 목록 내역 조회(전체)
    public List<Booking> ticket_list(@Param("today") String today) throws Exception;

    // 탑승 처리 - (탑승완료1, 미탑승0)
    public int ticket_update_c(int ticketNo, int checkedIn) throws Exception;
    public int ticket_update_b(int ticketNo, int isBoarded) throws Exception;

    // 탑승권 조회 - ticketNo
    public List<Booking> pas_ticketList(@Param("ticketNo") int ticketNo) throws Exception;


}
