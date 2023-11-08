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
    
    @Override
    public List<Booking> selectBookingByUser(String userId) throws Exception {

        List<Booking> ticketList = ticketMapper.selectBookingByUser(userId);

        return ticketList;

    }

    
}
