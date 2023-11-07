package com.joeun.dreamair.service;

import java.util.List;

import com.joeun.dreamair.dto.Booking;

public interface BookingService {
    
    
    // 가는편 항공권 조회
    public List<Booking> golist(Booking booking) throws Exception;

    // 오는편 항공권 조회
    public List<Booking> comelist(Booking booking) throws Exception;

    // 탑승객 정보 입력
    public int info(Booking booking) throws Exception;
}
