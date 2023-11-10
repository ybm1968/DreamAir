package com.joeun.dreamair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Booking;

@Mapper
public interface BookingMapper {

    // 가는편 항공권 목록 조회
    public List<Booking> golist(Booking booking) throws Exception;
    
    // 오는편 항공권 목록 조회
    public List<Booking> comelist(Booking booking) throws Exception;

    // 탑승객 정보 입력
    public int info(Booking booking) throws Exception;

    // 회원 - 가장 최근 예매 번호 조회
    public int latest_user_bookingNo(int userNo) throws Exception;

    // 비회원 - 가장 최근 예매 번호 조회
    public int latest_user2_bookingNo(int userNo2) throws Exception;

    // 티켓 발행 등록
    public int createTicket(Booking booking) throws Exception;

    // 예매 번호로 탑승권 정보 조회
    public List<Booking> ticketList_bookingNo(int bookingNo) throws Exception;
}
