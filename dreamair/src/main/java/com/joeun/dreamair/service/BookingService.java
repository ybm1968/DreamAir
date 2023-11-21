package com.joeun.dreamair.service;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.joeun.dreamair.dto.Booking;

public interface BookingService {
    
    
    // 가는편 항공권 조회
    public List<Booking> golist(Booking booking) throws Exception;

    // 오는편 항공권 조회
    public List<Booking> comelist(Booking booking) throws Exception;

    // 탑승객들 정보 입력
    public int infoPassngers(Booking booking, HttpServletRequest request, Principal principal) throws Exception;
    
    // 회원 - 가장 최근 예매 번호 조회
    public int latest_user_bookingNo(int userNo) throws Exception;

    // 비회원 - 가장 최근 예매 번호 조회
    public int latest_user2_bookingNo(int userNo2) throws Exception;
    
    // 여권 정보 입력 
    // public int infoPassport(Users user) throws Exception;

    // 편도 항공 스케줄(탑승객 유의사항 안내)
    public List<Booking> goScheduleList(Booking booking) throws Exception;

    // 왕복 항공 스케줄(탑승객 유의사항 안내)
    public List<Booking> comeScheduleList(Booking booking) throws Exception;

    // 예매 테이블 등록
    public int bookingInsert(Booking booking, Principal principal, HttpServletRequest request) throws Exception;

    // 티켓 발행 등록
    public int createTicket(Booking booking, Principal principal) throws Exception;
    
    // 항공기 좌석 조회
    public List<Booking> selectSeatStatus(int flightNo) throws Exception;

    // 항공기 좌석 조회 - 예약된 좌석
    public List<Booking> bookedSeatStatus(int flightNo) throws Exception;

    // 탑승권 리스트 조회 - 회원
    public List<Booking> selectBookingListByUser(String userId) throws Exception;

    // 탑승권 상세 조회
    public List<Booking> selectTicket(int ticketNo) throws Exception;

    // 출발지 조회
    public String selectDeparture(int productNoDeps);

    // 출발지 조회
    public String selectDestination(int productNoDeps);
    
    // 출발지명과 도착지명으로 노선 번호 조회
    public int selectRouteNo(String departure, String destination);

    // 탑승객 수만큼 info 테이블의 passenger_no 조회
    public List<String> selectLastPasNos(@Param("pasCount") int pasCount);

    // 예매 번호로 탑승권 정보 조회
    public List<Booking> ticketList_bookingNo(int bookingNo) throws Exception;

    // 도착지명으로 노선 번호 조회
    public int selectRouteNoByDes(String destination);

    // 마지막 booking_no 조회
    public int selectLastBookingNo(int bookingNo) throws Exception;

    // seat 테이블 업데이트
    public int updateSeat(int flightNo, String seatNo) throws Exception;
}
