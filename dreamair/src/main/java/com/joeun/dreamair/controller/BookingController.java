package com.joeun.dreamair.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Users;
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
        log.info("가는편 노선번호 : " + booking.getRouteNo());
        
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
        log.info("오는편 노선번호 : " + booking.getRouteNoDes());

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
        log.info("가는편 노선번호 : " + booking.getRouteNoDep());
        log.info("오는편 노선번호 : " + booking.getRouteNoDes());
        log.info("info 왕복여부 : " + booking.getRoundTrip());

        model.addAttribute("booking", booking);
        
        return "booking/info";
    }
 

    @PostMapping(value="/info")
    public String infoPro(Model model, Booking booking, Users user, RedirectAttributes rttr) throws Exception{ 
        log.info("탑승객 이름 : " + booking.getPassengerNames()[0]);
        log.info("infoPro 왕복여부 : " + booking.getRoundTrip());
        

        int result1 = 0;
        int result2 = 0;

        result1 = bookingService.infoPassngers(booking);
        // result2 = bookingService.infoPassport(user);
        rttr.addFlashAttribute("user", user);     
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
        log.info("탑승객 번호 : " + booking.getPassengerNo());
        log.info("신분증 종류 : " + booking.getPinTypes()[0]);
        
        model.addAttribute("booking", booking);
      
        return "booking/seat";
    }
    
    @PostMapping(value="/seat")
    public String seatPro() {
        
        
        return "booking/notice";
    }
    

    @GetMapping(value="/notice")
    public String notice(Model model, Booking booking) throws Exception {
        log.info("탑승객 이름 : " + booking.getPassengerName());
        log.info("탑승객 이름 배열 : " + booking.getPassengerNames()[0]);
        log.info("탑승객 번호 : " + booking.getPassengerNo());
        log.info("탑승객 수 : " + booking.getPasCount());
        log.info("왕복 : " + booking.getRoundTrip());

        
        if (booking.getRoundTrip().equals("편도")) {
            // 편도 조회
            List<Booking> goBookingList = bookingService.goScheduleList(booking);
            model.addAttribute("goBookingList", goBookingList);
        } else {
            // 왕복 조회
            List<Booking> goBookingList = bookingService.goScheduleList(booking);
            model.addAttribute("goBookingList", goBookingList);

            List<Booking> comeBookingList = bookingService.comeScheduleList(booking);
            model.addAttribute("comeBookingList", comeBookingList);
        }
        model.addAttribute("bookingInfo", booking);

        return "booking/notice";
    }

    @GetMapping(value="/payment")
    public String payment() throws Exception {
        return "booking/payment";
    }


    // 쿼리문은 2개 가는편 조회 오는편 조회
    // 편도는 가는편 정보만 필요
    // 왕복은 가는편 오는편 둘다 필요
    // 편도는 그냥 조회해서 bookingList로 모델에 등록
    // 왕복은 bookingList 2개 필요할듯 
    // 서비스를 가는편 오는편 두개 만들고 컨트롤러에서 편도일때 가는편만호출 왕복일때는 두개다 호출

    // 탑승객의 여러명 정보가 넘어오겠지 배열로 ???
    //

    
    
    
    

}
