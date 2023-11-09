package com.joeun.dreamair.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        List<Booking> bookingList = bookingService.golist(booking);   //?
        model.addAttribute("bookingList", bookingList);     //??
        model.addAttribute("booking", booking);

        return "booking/list";
    }


    // 가는 편
    @GetMapping(value="/component/golist")
    public String gobookingList(Model model, Booking booking) throws Exception {
        log.info("편도 여부: " + booking.getRoundTrip());
        log.info("편도 인원수: " + booking.getPasCount());
        
        List<Booking> bookingList = bookingService.golist(booking);
        model.addAttribute("bookingList", bookingList);
        model.addAttribute("bookingInfo", booking);
        return "UI/component/booking/list";
    }

    // 오는 편
    @GetMapping(value="/component/comelist")
    public String comebookingList(Model model, Booking booking) throws Exception {
        log.info("오는편 출발지 : " + booking.getDeparture());
        log.info("*오는편 getProductNoDep : " + booking.getProductNoDep());

        List<Booking> bookingList = bookingService.comelist(booking);
        model.addAttribute("bookingList", bookingList);
        model.addAttribute("bookingInfo", booking);
        return "UI/component/booking/list";
    }
    


    @GetMapping(value="/info")
    public String info(Model model, Booking booking) {
        log.info("가는편 상품번호 : " + booking.getProductNoDep());
        log.info("오는편 상품번호 : " + booking.getProductNoDes());
        log.info("인원수 : " + booking.getPasCount());
        log.info("info 왕복여부 : " + booking.getRoundTrip());

        model.addAttribute("booking", booking);
        
        return "booking/info";
    }


    @PostMapping(value="/info")
    public String infoPro(Model model, Booking booking, RedirectAttributes rttr) throws Exception{ 
        log.info("탑승객 이름 : " + booking.getPassengerNames()[0]);
        log.info("infoPro 왕복여부 : " + booking.getRoundTrip());

        int result = 0;

        result = bookingService.infoList(booking);
        rttr.addFlashAttribute("booking", booking);     
    
        return "redirect:/booking/seat";
    }
    

    @GetMapping(value="/seat")
    public String seat(Model model, Booking booking) {
        // 값을 조회
        log.info("탑승객 수 : " + booking.getPasCount());
        log.info("seat 왕복여부 : " + booking.getRoundTrip());
        log.info("탑승객 이름 : " + booking.getPassengerName());
        log.info("탑승객 이름 배열 : " + booking.getPassengerNames()[0]);
        
        model.addAttribute("booking", booking);
      
        return "booking/seat";
    }
    
    @PostMapping(value="/seat")
    public String seatPro() {
        
        
        return "booking/notice";
    }
    

    @GetMapping(value="/notice")
    public String notice() {
        return "booking/notice";
    }

    @GetMapping(value="/payment")
    public String payment() {
        return "booking/payment";
    }


    
    
    
    

}
