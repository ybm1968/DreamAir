package com.joeun.dreamair.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.service.BookingService;

import groovyjarjarpicocli.CommandLine.Model;



@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    

    // 출발지 날짜 도착지(ticket), 탑승인원 왕복여부(booking) 를 정보()에 맞는 검색결과를 보여주기
    @GetMapping(value="/list")
    public String select(Model model, Booking booking) {


        

        return "user/select";
    }

    @GetMapping(value="/info")
    public String info() {
        return "user/info";
    }

    @GetMapping(value="/seat")
    public String seat() {
        return "user/seat";
    }
    
    @GetMapping(value="/notice")
    public String notice() {
        return "user/notice";
    }

    @GetMapping(value="/payment")
    public String payment() {
        return "user/payment";
    }
    
    
    

}
