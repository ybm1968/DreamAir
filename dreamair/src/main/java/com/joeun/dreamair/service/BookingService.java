package com.joeun.dreamair.service;

import java.security.Principal;
import java.util.List;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Users;

public interface BookingService {
    
    
    // 가는편 항공권 조회
    public List<Booking> golist(Booking booking) throws Exception;

    // 오는편 항공권 조회
    public List<Booking> comelist(Booking booking) throws Exception;

    // 탑승객들 정보 입력
    public int infoPassngers(Booking booking) throws Exception;
    
    // 여권 정보 입력 
    // public int infoPassport(Users user) throws Exception;

    // 편도 항공 스케줄(탑승객 유의사항 안내)
    public List<Booking> goScheduleList(Booking booking) throws Exception;

    // 왕복 항공 스케줄(탑승객 유의사항 안내)
    public List<Booking> comeScheduleList(Booking booking) throws Exception;

    // 예매 테이블 등록
    public int bookingInsert(Booking booking, Principal principal) throws Exception;

    // 티켓 발행 등록
    public int createTicket(Booking booking) throws Exception;

    // 예매 번호로 탑승권 정보 조회
    public List<Booking> ticketList_bookingNo(int bookingNo) throws Exception;
}
