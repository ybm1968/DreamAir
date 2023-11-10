package com.joeun.dreamair.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    private UserService userService;

    @Autowired
    private BookingService bookingService; 
    
    // 항공권 조회 목록 -> 예매
    @GetMapping(value="/list")
    public String list(Model model, Booking booking) throws Exception {
        // log.info("리스트 출발지 : " + booking.getDeparture());
        // log.info("탑승인원 : " + booking.getPasCount());
        List<Booking> bookingList = bookingService.golist(booking);   //?
        // log.info("bookingList 출력확인 : " + bookingList.get(0).getPasCount());
        model.addAttribute("bookingList", bookingList);     //??
        model.addAttribute("booking", booking);

        return "booking/list";
    }

    // 가는 편
    @GetMapping(value="/component/golist")
    public String gobookingList(Model model, Booking booking) throws Exception {
        // log.info("가는편 출발지 : " + booking.getDeparture());
        // log.info("*가는편 getProductNoDep : " + booking.getProductNoDep());

        List<Booking> bookingList = bookingService.golist(booking);
        model.addAttribute("bookingList", bookingList);
        model.addAttribute("bookingInfo", booking);
        return "UI/component/booking/list";
    }

    // 오는 편
    @GetMapping(value="/component/comelist")
    public String comebookingList(Model model, Booking booking) throws Exception {
        // log.info("오는편 출발지 : " + booking.getDeparture());
        // log.info("오는편 getProductNo : " + booking.getProductNo());
        // log.info("*오는편 getProductNoDep : " + booking.getProductNoDep());

        List<Booking> bookingList = bookingService.comelist(booking);
        model.addAttribute("bookingList", bookingList);
        model.addAttribute("bookingInfo", booking);
        return "UI/component/booking/list";
    }
    
    // 탑승객 정보 입력
    @GetMapping(value="/info")
    public String info(Model model, Booking booking) {
        // log.info("가는편 상품번호 : " + booking.getProductNoDep());
        // log.info("오는편 상품번호 : " + booking.getProductNoDes());
        // log.info("인원수 : " + booking.getPasCount());

        model.addAttribute("booking", booking);
        
        return "booking/info";
    }

    @PostMapping(value="/info")
    public String infoPro(Model model, Booking booking, RedirectAttributes rttr) throws Exception{ 
        // log.info("탑승객 이름 : " + booking.getPassengerNames()[0]);
        // log.info("infoPro 왕복여부 : " + booking.getRoundTrip());

        int result = 0;

        result = bookingService.infoList(booking);
        rttr.addFlashAttribute("booking", booking);
    
        return "redirect:/booking/seat";
    }

    // 탑승객 유의사항
    @GetMapping(value="/notice")
    public String notice(){
        return "booking/notice";
    }
    
    // 좌석 선택
    @GetMapping(value="/seat")
    public String seat(Model model, @ModelAttribute("booking") Booking booking) throws Exception {
        
        List<Booking> seatStatus = bookingService.selectSeatStatus();

        log.info("booking : " + booking);

        int productNoDepValue = booking.getProductNoDeps()[0];
        int productNoDesValue = booking.getProductNoDess()[0];

        log.info("출발지 값 : " + productNoDepValue);
        log.info("도착지 값 : " + productNoDesValue);

        String departure = bookingService.selectDeparture(productNoDepValue);
        String destination = bookingService.selectDeparture(productNoDesValue);

        log.info("출발지 명 : " + departure);
        log.info("도착지 명 : " + destination);



        // 모델에 등록
        model.addAttribute("booking", booking);
        model.addAttribute("seatStatus", seatStatus);
        model.addAttribute("departure", departure);
        model.addAttribute("destination", destination);
        
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

    // 결제 완료
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
    @PostMapping(value="/ticketInfo")
    public String ticketInfo() {
        return "booking/ticketInfo";
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