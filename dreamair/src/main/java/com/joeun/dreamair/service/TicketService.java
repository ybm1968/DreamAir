package com.joeun.dreamair.service;

import java.util.List;

import com.joeun.dreamair.dto.Booking;

public interface TicketService {


    // 탑승권 조회 - 회원
    public List<Booking> selectBookingByUser(String userId) throws Exception;

    
}
