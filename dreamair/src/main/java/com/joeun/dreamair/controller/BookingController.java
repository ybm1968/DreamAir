package com.joeun.dreamair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.service.BookingService;

import lombok.extern.slf4j.Slf4j;





@Slf4j
@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;
    

    // 출발지 날짜 도착지(ticket), 탑승인원 왕복여부(booking) 를 정보()에 맞는 검색결과를 보여주기
    @GetMapping(value="/list")
    public String list(Model model, Booking booking) throws Exception {
        log.info("booking.departure : " + booking.getDeparture());
        List<Booking> bookingList = bookingService.list(booking);
        model.addAttribute("bookingList", bookingList);

        return "user/list";
    }

    @GetMapping(value="/info")
    public String info(Model model, Booking booking) {
        log.info("상품번호 : " + booking.getProductNo());
        log.info("노선번호 : " + booking.getRouteNo());
        model.addAttribute("booking", booking);
        
        return "user/info";
    }

    @PostMapping(value="/info")
    public String infoPro(Booking booking) throws Exception{
        int result = bookingService.info(booking);
        
        return "user/seat";
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
