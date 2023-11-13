package com.joeun.dreamair.controller;

import java.security.Principal;
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
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.service.BookingService;
import com.joeun.dreamair.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService; 
    
    @Autowired
    private UserService userService;

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
        log.info("가는편 노선번호 : " + bookingList.get(0).getRouteNo());
        model.addAttribute("bookingInfo", booking);
        return "UI/component/booking/list";
    }
    
    // 오는 편
    @GetMapping(value="/component/comelist")
    public String comebookingList(Model model, Booking booking) throws Exception {
        log.info("오는편 출발지 : " + booking.getDeparture());
        log.info("오는편 상품번호(가는편) : " + booking.getProductNoDep());
        log.info("오는편 노선번호(오는편) : " + booking.getRouteNoDes());

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
        // rttr.addFlashAttribute("user", user);     
        rttr.addFlashAttribute("booking", booking);     
    
        return "redirect:/booking/seat";
    }
    

    @GetMapping(value="/seat")
    public String seat(Model model, Booking booking) {
        // 값을 조회
        log.info("탑승객 수 : " + booking.getPasCount());
        log.info("seat 왕복여부 : " + booking.getRoundTrip());
        log.info("탑승객 이름 배열 : " + booking.getPassengerNames()[0]);
        
        model.addAttribute("booking", booking);
      
        return "booking/seat";
    }
    
    @PostMapping(value="/seat")
    public String seatPro() {
        
        
        return "booking/notice";
    }
    

    @GetMapping(value="/notice")
    public String notice(Model model, Booking booking) throws Exception {
        log.info("탑승객 이름 배열 : " + booking.getPassengerNames()[0]);
        log.info("탑승객 수 : " + booking.getPasCount());
        log.info("왕복 : " + booking.getRoundTrip());

        List<Booking> goBookingList = new ArrayList<Booking>();
        List<Booking> comeBookingList = new ArrayList<Booking>();
        
        if (booking.getRoundTrip().equals("편도")) {
            // 편도 조회
            goBookingList = bookingService.goScheduleList(booking);
        } else {
            // 왕복 조회
            goBookingList = bookingService.goScheduleList(booking);
            comeBookingList = bookingService.comeScheduleList(booking);
        }
        model.addAttribute("goBookingList", goBookingList);
        model.addAttribute("comeBookingList", comeBookingList);
        model.addAttribute("bookingInfo", booking);

        return "booking/notice";
    }

    @GetMapping(value="/payment")
    public String payment(Model model, Booking booking, Principal principal) throws Exception {
        log.info("페이먼트 탑승객 이름 배열 : " + booking.getPassengerNames()[0]);
        log.info("페이먼트 탑승객 번호 배열 : " + booking.getPassengerNos()[0]);
        log.info("페이먼트 탑승객 수 : " + booking.getPasCount());
        log.info("페이먼트 왕복 : " + booking.getRoundTrip());

        List<Booking> goBookingList = new ArrayList<Booking>();
        List<Booking> comeBookingList = new ArrayList<Booking>();
        
        if (booking.getRoundTrip().equals("편도")) {
            // 편도 조회
            goBookingList = bookingService.goScheduleList(booking);
        } else {
            // 왕복 조회
            goBookingList = bookingService.goScheduleList(booking);
            comeBookingList = bookingService.comeScheduleList(booking);
        }
        model.addAttribute("goBookingList", goBookingList);
        model.addAttribute("comeBookingList", comeBookingList);
        model.addAttribute("bookingInfo", booking);

        // 회원 : userNo 추출, 비회원 : userNo2 추출
        Users user = userService.selectById2(principal);
        if (user.getUserId().equals("GUEST")) {
            log.info("비회원 유저번호 : " + user.getUserNo2());
        } else {
            log.info("회원 유저번호 : " + user.getUserNo());
        }
        
        model.addAttribute("user", user);
        // model.addAttribute("booking", booking);

        return "booking/payment";
    }

    // 결제 처리  - 예매 번호 발급
    @PostMapping(value="/payment")
    public String paymentPro(Model model, Booking booking) throws Exception {

        // ✅ TODO 티켓 발행 등록 요청
        int result = bookingService.createTicket(booking);

        // 같은 bookingNo에 대한 ticket 정보 조회
        int bookingNo = booking.getBookingNo();
        List<Booking> ticketList_bookingNo = bookingService.ticketList_bookingNo(bookingNo);
        model.addAttribute("ticketList_bookingNo", ticketList_bookingNo);

        // ticketNO 받아서 qr 발행
        
        return "redirect:/booking/payment_complete";
    }
    

    @PostMapping(value = "/bookingInsert")
    public String bookingInsert(Booking booking) throws Exception {
        log.info("이름 : " + booking.getPassengerNames()[0]);
        int result = bookingService.bookingInsert(booking);

        return "booking/success";
    }

    @GetMapping(value="/success")
    public String success(String result, String productId) {
        log.info("결제 성공!!!");
        log.info("result : " + result);
        log.info("productId : " + productId);
        return "booking/success";
    }



    
    
    
    

}
