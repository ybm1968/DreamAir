package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.mapper.BookingMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public List<Booking> list(Booking booking) throws Exception {
        log.info("booking.destionation : " + booking.getDestination());
        List<Booking> bookingList = bookingMapper.list(booking);

        return bookingList;
    }
    
}
