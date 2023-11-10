package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Users;
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
    public int infoPassngers(Booking booking) throws Exception {
        log.info("서비스임플 이메일 : " + booking.getEmails()[0]);
        log.info("서비스임플 인원수 : " + booking.getPasCount());
        int result = 0;
         
        for (int i = 0; i < booking.getPasCount(); i++) {
            Booking bookingItem = new Booking();
            bookingItem.setProductNoDep(booking.getProductNoDeps()[i]);
            bookingItem.setRouteNoDep(booking.getRouteNoDeps()[i]);
            bookingItem.setPassengerName(booking.getPassengerNames()[i]);
            bookingItem.setFirstName(booking.getFirstNames()[i]);
            bookingItem.setLastName(booking.getLastNames()[i]);
            bookingItem.setGender(booking.getGenders()[i]);
            bookingItem.setBirth(booking.getBirths()[i]);
            bookingItem.setPinType(booking.getPinTypes()[i]);
            bookingItem.setPhone(booking.getPhones()[i]);
            bookingItem.setEmail(booking.getEmails()[i]);
            bookingItem.setUserPw(booking.getUserPw());

            if ( booking.getRoundTrip().equals("왕복")) {
                bookingItem.setProductNoDes(booking.getProductNoDess()[i]);
                bookingItem.setRouteNoDes(booking.getRouteNoDess()[i]);
            }

            bookingMapper.infoPassngers(bookingItem);
            result++;
        }

        log.info("왕복 등록결과 : " + result);
        
        return result;
    }

    // @Override
    // public int infoPassport(Users user) throws Exception {
    //     log.info("여권번호 : " + user.getPassportNos()[0]);
    //     log.info("라스트네임 : " + user.getLastNames()[0]);
    //     log.info("여권만료일자 : " + user.getExpirationDates()[0]);
    //     log.info("여권번호 : " + user.getUserId());

    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
    //     int result = 0;
        
    //     for (int i = 0; i < user.getPassportNos().length; i++) {
    //         Users userItem = new Users();
    //         userItem.setPassportNo(user.getPassportNos()[i]);
    //         userItem.setPinType(user.getPinTypes()[i]);
    //         userItem.setLastName(user.getLastNames()[i]);
    //         userItem.setFirstName(user.getFirstNames()[i]);
    //         userItem.setNationality(user.getNationalitys()[i]);
    //         userItem.setExpirationDate(user.getExpirationDates()[i]);
            
    //         if(authentication.isAuthenticated()) {
    //             userItem.setUserId(user.getUserId()); 
    //         } 

    //         bookingMapper.infoPassport(userItem);
    //         result++;
    //     }

    //     return result;
    // }


    @Override
    public List<Booking> goScheduleList(Booking booking) throws Exception {
        List<Booking> bookingList = bookingMapper.goScheduleList(booking);
        
        return bookingList;
    }
    
    @Override
    public List<Booking> comeScheduleList(Booking booking) throws Exception {
        List<Booking> bookingList = bookingMapper.comeScheduleList(booking);

        return bookingList;
    }

    
    
}
