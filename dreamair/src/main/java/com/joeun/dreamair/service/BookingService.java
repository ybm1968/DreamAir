package com.joeun.dreamair.service;

import java.util.List;

import com.joeun.dreamair.dto.Booking;

public interface BookingService {
    
    
    // 가는편 항공권 조회
    public List<Booking> golist(Booking booking) throws Exception;

    // 오는편 항공권 조회
    public List<Booking> comelist(Booking booking) throws Exception;

    // 탑승객들 정보 입력
    public int infoList(Booking booking) throws Exception;
    
    // 회원 - 가장 최근 예매 번호 조회
    public int latest_user_bookingNo(int userNo) throws Exception;

    // 비회원 - 가장 최근 예매 번호 조회
    public int latest_user2_bookingNo(int userNo2) throws Exception;

    // 티켓 발행 등록
    public int createTicket(Booking booking) throws Exception;

    // 항공기 좌석 조회
    public List<Booking> selectSeatStatus(int flightNo) throws Exception;

    // 탑승권 리스트 조회 - 회원
    public List<Booking> selectBookingListByUser(String userId) throws Exception;

    // 탑승권 상세 조회
    public List<Booking> selectTicket(int bookingNo) throws Exception;

    // 출발지 조회
    public String selectDeparture(int productNoDeps);

    // 출발지 조회
    public String selectDestination(int productNoDess);
    
    // 출발지명과 도착지명으로 노선 번호 조회
    public int selectRouteNo(String departure, String destination);

}
