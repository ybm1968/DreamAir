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
}