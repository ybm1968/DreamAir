package com.joeun.dreamair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Booking;

@Mapper
public interface TicketMapper {
    
    // 탑승권 리스트 조회 - 회원
    public List<Booking> selectBookingListByUser(String userId) throws Exception;

    // 탑승권 상세 조회
    public List<Booking> selectTicket(int bookingNo) throws Exception;

}
