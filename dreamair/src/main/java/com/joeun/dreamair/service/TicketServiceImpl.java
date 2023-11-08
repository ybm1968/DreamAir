package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.mapper.TicketMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;
    

    // 탑승권 리스트 조회 - 회원
    @Override
    public List<Booking> selectBookingListByUser(String userId) throws Exception {

        List<Booking> ticketList = ticketMapper.selectBookingListByUser(userId);

        return ticketList;

    }


    // 탑승권 상세 조회
    @Override
    public List<Booking> selectTicket(int bookingNo) throws Exception {

        List<Booking> viewTicket = ticketMapper.selectTicket(bookingNo);

        return viewTicket;

    }

    
}
