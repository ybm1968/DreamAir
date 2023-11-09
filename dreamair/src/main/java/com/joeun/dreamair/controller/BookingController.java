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
import org.springframework.web.bind.annotation.RequestParam;






@Slf4j
@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService; 
    

    // 출발지 날짜 도착지(ticket), 탑승인원 왕복여부(booking) 를 정보()에 맞는 검색결과를 보여주기
    @GetMapping(value="/list")
    public String list(Model model, Booking booking) throws Exception {
        log.info("리스트 출발지 : " + booking.getDeparture());
        log.info("탑승인원 : " + booking.getPasCount());
        List<Booking> bookingList = bookingService.golist(booking);   //?
        // log.info("bookingList 출력확인 : " + bookingList.get(0).getPasCount());
        model.addAttribute("bookingList", bookingList);     //??
        model.addAttribute("booking", booking);

        return "booking/list";
    }


    // 가는 편
    @GetMapping(value="/component/golist")
    public String gobookingList(Model model, Booking booking) throws Exception {
        log.info("가는편 출발지 : " + booking.getDeparture());
        log.info("*가는편 getProductNoDep : " + booking.getProductNoDep());

        List<Booking> bookingList = bookingService.golist(booking);
        model.addAttribute("bookingList", bookingList);
        model.addAttribute("bookingInfo", booking);
        return "UI/component/booking/list";
    }

    // 오는 편
    @GetMapping(value="/component/comelist")
    public String comebookingList(Model model, Booking booking) throws Exception {
        log.info("오는편 출발지 : " + booking.getDeparture());
        log.info("오는편 getProductNo : " + booking.getProductNo());
        log.info("*오는편 getProductNoDep : " + booking.getProductNoDep());

        List<Booking> bookingList = bookingService.comelist(booking);
        model.addAttribute("bookingList", bookingList);
        model.addAttribute("bookingInfo", booking);
        return "UI/component/booking/list";
    }
    


    @GetMapping(value="/info")
    public String info(Model model, Booking booking) {
        log.info("가는편 상품번호 : " + booking.getProductNoDep());
        log.info("가는편 상품코드 : " + booking.getProductIdDep());
        log.info("오는편 상품번호 : " + booking.getProductNoDes());
        log.info("오는편 상품코드 : " + booking.getProductIdDes());
        log.info("인원수 : " + booking.getPasCount());

        model.addAttribute("booking", booking);
        
        return "booking/info";
    }

    @PostMapping(value="/info")
    public String infoPro(List<Booking> bookingList) throws Exception{
        log.info("탑승객1 이름 : " + bookingList.get(0).getPassengerName());
        log.info("탑승객2 이름 : " + bookingList.get(0).getPassengerName());

        int result = 0;
        for (Booking booking : bookingList) {
            result = bookingService.info(booking);
            result++;
        }

        log.info("인서트결과 : " + result);

        // 탑승객 수 만큼 반복해서 인서트???
        
        return "booking/seat";
    }
    

    @GetMapping(value="/seat")
    public String seat(Model model, Booking booking) throws Exception {
        
        List<Booking> seatStatus = bookingService.selectSeatStatus();

        log.info("좌석 어디 선택할 수 있는지 보자 : " + seatStatus);
        
        // 값을 조회
        model.addAttribute("booking", booking);
        model.addAttribute("seatStatus", seatStatus);
        
      
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
    
    

    /**
     * seat 페이지에서 좌석 선택하여 선택 완료 시 -> form 제출하며 notice 페이지로 이동
     * @return
     */
    @PostMapping(value = "/notice")
    public String seatPro(@RequestParam("depSeat") String depSeat, Model model) {

        
        
        System.out.println("선택한 좌석: " + depSeat);

        model.addAttribute("selectSeat", depSeat);

        return "redirect:/booking/notice";
    }

}

