package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.mapper.BookingMapper;

@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingMapper bookingMapper;

    @Override
    public List<Booking> list(Booking booking) throws Exception {
        //booking = bookingMapper.list(booking);

        throw new UnsupportedOperationException("Unimplemented method 'select'");
    }
    
}
