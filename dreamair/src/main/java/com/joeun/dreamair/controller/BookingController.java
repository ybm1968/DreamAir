package com.joeun.dreamair.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.joeun.dreamair.dto.Board;
import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.QR;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.mapper.BookingMapper;
import com.joeun.dreamair.mapper.UserMapper;
import com.joeun.dreamair.service.BookingService;
import com.joeun.dreamair.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService;
    
    // 항공권 조회 목록 -> 예매
    @GetMapping(value="/list")
    public String list(){
        log.info("[GET] - /booking/list");
        return "booking/list";
    }

    // 탑승객 정보 입력
    @GetMapping(value="/info")
    public String info(){
        log.info("[GET] - /booking/list");
        return "booking/info";
    }

    // 탑승객 유의사항
    @GetMapping(value="/notice")
    public String notice(){
        return "booking/notice";
    }

    // 좌석 선택
    @GetMapping(value="/seat")
    public String seat(){
        return "booking/seat";
    }

    // 결제
    @GetMapping(value="/payment")
    public String payment(Model model, Principal principal, Booking booking) throws Exception {

        // 결제가 완료가 되면, booking 테이블에 정보 추가
        
        
        // 회원 : userNo 추출, 비회원 : userNo2 추출
        String loginId = principal != null ? principal.getName() : "GUEST";
        Users user = userService.selectById(loginId);
        
        // 초기값 설정
        int userNo = 0;
        int userNo2 = 0;

        // loginId에서 userNo 추출
        userNo = user.getUserNo();
        userNo2 = user.getUserNo2();
        
        // booking 테이블에서 최근 bookingNo 추출
        int bookingNo = bookingService.latest_user_bookingNo(userNo);
        int bookingNo2 = bookingService.latest_user2_bookingNo(userNo2);

        model.addAttribute("bookingNo", bookingNo);
        model.addAttribute("bookingNo2",bookingNo2);

        return "booking/payment";
    }

    // 결제 처리  - 예매 번호 발급
    @PostMapping(value="/payment")
    public String paymentPro(Booking booking) throws Exception {
        // ✅ TODO 티켓 발행 등록 요청
        int result = bookingService.createTicket(booking);

        return "redirect:/booking/payment_complete";
    }

    @GetMapping(value="/payment_complete")
    public String paymentComplete() {
        return "booking/payment";
    }

    // 탑승권 발행
    @PostMapping(value="/ticket")
    public String ticket() {
        return "booking/ticket";
    }

  
        
    // 탑승권 상세 페이지
    @PostMapping(value="/ticketinfo")
    public String ticketinfo() {
        return "booking/ticketinfo";
    }
}
