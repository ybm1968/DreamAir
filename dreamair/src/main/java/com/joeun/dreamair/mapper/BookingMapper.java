package com.joeun.dreamair.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.joeun.dreamair.dto.Booking;

@Mapper
public interface BookingMapper {

    // 항공권 목록 조회
    public List<Booking> list(Booking booking) throws Exception;
}
