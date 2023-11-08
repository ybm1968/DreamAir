package com.joeun.dreamair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Booking;

@Mapper
public interface TicketMapper {
    
    // 탑승권 리스트 조회 - 회원
    public List<Booking> selectBookingByUser(String userId) throws Exception;

}
