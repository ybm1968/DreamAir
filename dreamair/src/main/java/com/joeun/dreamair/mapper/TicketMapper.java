package com.joeun.dreamair.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Booking;

@Mapper
public interface TicketMapper {
    
    // 탑승권 리스트 조회 - 회원
    public Booking selectBookingByUser(String userId) throws Exception;

}
