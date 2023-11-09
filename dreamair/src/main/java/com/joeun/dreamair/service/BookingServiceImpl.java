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
    public List<Booking> golist(Booking booking) throws Exception {
        log.info("서비스임플 가는편 도착지 : " + booking.getDestination());
        log.info("시버스임플 가는편 출발날짜 : " + booking.getDepartureDate());

        List<Booking> bookingList = bookingMapper.golist(booking);

        return bookingList;
    }

     @Override
    public List<Booking> comelist(Booking booking) throws Exception {
        log.info("서비스임플 오는편 도착지 : " + booking.getDestination());
        log.info("서비스임플 오는편 출발날짜 : " + booking.getDepartureDate());

        List<Booking> bookingList = bookingMapper.comelist(booking);

        return bookingList;
    }

    @Override
    public int info(Booking booking) throws Exception {
        log.info("booking.email : " + booking.getEmail());
        int result = bookingMapper.info(booking);
        
        return result;
    }

    /**
     * 항공기 좌석 조회
     */
    @Override
    public List<Booking> selectSeatStatus() throws Exception {

        List<Booking> seatList = bookingMapper.selectSeatStatus();

        return seatList;

    }
    
}