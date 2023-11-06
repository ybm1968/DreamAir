package com.joeun.dreamair.service;

import java.util.List;

import com.joeun.dreamair.dto.Booking;

public interface BookingService {

    // 항공권 조회
    public List<Booking> list(Booking booking) throws Exception;

    // 탑승객 정보 입력
    public int info(Booking booking) throws Exception;
}