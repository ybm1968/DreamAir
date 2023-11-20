package com.joeun.dreamair.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.service.BookingService;
import com.joeun.dreamair.service.ProductService;
import com.joeun.dreamair.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookingService bookingService; 

    @Autowired
    private ProductService productService;
    
    // 항공권 조회 목록 -> 예매
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
    
    // 탑승객 정보 입력
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
    public String infoPro(Model model, Booking booking, Users user, RedirectAttributes rttr, HttpServletRequest request) throws Exception{ 
        log.info("탑승객 이름 : " + booking.getPassengerNames()[0]);
        log.info("infoPro 왕복여부 : " + booking.getRoundTrip());
        
        int result1 = 0;
        int result2 = 0;

        result1 = bookingService.infoPassngers(booking, request);
        // result2 = bookingService.infoPassport(user);
        // rttr.addFlashAttribute("user", user);     
        rttr.addFlashAttribute("booking", booking);     
    
        return "redirect:/booking/seat";
    }
    
        
    // 좌석 선택
    @GetMapping(value="/seat")
    public String seat(Model model, @ModelAttribute("booking") Booking booking) throws Exception {

        int productNoDepValue = booking.getProductNoDeps()[0];
        int productNoDesValue = booking.getProductNoDeps()[0];

        String departure = bookingService.selectDeparture(productNoDepValue);
        String destination = bookingService.selectDestination(productNoDesValue);
        
        // 출발지명과 도착지명으로 노선 조회해서 항공기 번호 부여
        int routeNoToFlightNo = bookingService.selectRouteNo(departure, destination);
        booking.setFlightNo(routeNoToFlightNo);

        booking.setDeparture(departure);
        booking.setDestination(destination);
        booking.setFlightNo(productNoDepValue);
        
        List<Booking> seatStatus = bookingService.selectSeatStatus(routeNoToFlightNo);
        List<String> selectLastPasNoss = bookingService.selectLastPasNos(booking.getPasCount());
        
        booking.setPassengerNoss(selectLastPasNoss);
        
        log.info("가는 편 페이지 부킹 객체 : " + booking);
        
        // 모델에 등록
        model.addAttribute("booking", booking);
        model.addAttribute("seatStatus", seatStatus);

        return "booking/seat";
    }


    // 예약된 좌석 데이터 가져오기
    @ResponseBody       // 데이터만 응답
    @GetMapping(value="/booked")
    public List<Booking> bookedSeatList(int flightNo) throws Exception {
        log.info("filghtNo : " + flightNo);
        List<Booking> bookedSeatList = bookingService.bookedSeatStatus(flightNo);
        return bookedSeatList;
    }
    


    // 왕복 여부에 따라 페이지 처리
    @PostMapping(value = "/seat")
    public String seatPro(Model model, @ModelAttribute("booking") Booking booking) {

        if ("왕복".equals(booking.getRoundTrip())) {
            // "왕복"일 경우 seat_rt 페이지로 이동
            return "redirect:/booking/seat_rt";
        } else {
            // "왕복"이 아닐 경우 notice 페이지로 이동

            // JavaScript 코드 추가
            model.addAttribute("booking", booking);
            return "booking/notice";
        }
    }

    
    // 좌석 선택 - 왕복일 시
    @GetMapping(value="/seat_rt")
    public String seatRt(Model model, @ModelAttribute("booking") Booking booking) throws Exception {

        String destination = booking.getDestination();

        int routeNoToFlightNo = bookingService.selectRouteNoByDes(destination);

        booking.setFlightNo(routeNoToFlightNo);

        List<Booking> seatStatus = bookingService.selectSeatStatus(routeNoToFlightNo);

        log.info("오는 편 페이지 부킹 객체 : " + booking);

        // 모델에 등록
        model.addAttribute("booking", booking);
        model.addAttribute("seatStatus", seatStatus);
        
        return "booking/seat_rt";
    }


    // 탑승객 유의사항
    @GetMapping(value="/notice")
    public String notice(Model model, Booking booking) throws Exception {
            log.info("탑승객 이름 배열 : " + booking.getPassengerNames()[0]);
            log.info("탑승객 수 : " + booking.getPasCount());
            log.info("왕복 : " + booking.getRoundTrip());
            log.info("노티스 좌석 : " + booking);

            log.info("noticeGET 페이지 부킹 객체 : " + booking);

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


    // 결제
    @GetMapping(value="/payment")
    public String payment(Model model, Booking booking, Principal principal, HttpServletRequest request) throws Exception {
        log.info("페이먼트 booking : " + booking);

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
        Users user = userService.selectById2(principal, request);
        if ( principal == null ) {
            log.info("비회원 유저번호 : " + user.getUserNo2());
        } else {
            log.info("회원 유저번호 : " + user.getUserNo());
        }
         
        model.addAttribute("user", user);

        return "booking/payment";
    }
    

    @PostMapping(value = "/bookingInsert")
    public String bookingInsert(Model model, Booking booking, Principal principal, RedirectAttributes rttr, HttpServletRequest request) throws Exception {
        log.info("booking 객체 조회 : " + booking);
        int result1 = bookingService.bookingInsert(booking, principal, request);
        productService.productOut(booking);
        int bookingNum = 0;
        
        Users user = userService.selectById2(principal, request);
        if( (principal == null) ) {
            log.info("비회원 번호 : " + user.getUserNo2());
            bookingNum = bookingService.latest_user2_bookingNo(user.getUserNo2());  
            booking.setBookingNo2(bookingNum);
        } else {
            bookingNum = bookingService.latest_user_bookingNo(user.getUserNo());  
            booking.setBookingNo(bookingNum);
        }

        // // ✅ TODO 티켓 발행 등록 요청
        int result = bookingService.createTicket(booking, principal, request);

        // 같은 bookingNo에 대한 ticket 정보 조회
        int bookingNo = booking.getBookingNo();
        List<Booking> ticketList_bookingNo = bookingService.ticketList_bookingNo(bookingNo);        // 정수형으로 반환값 설정
        model.addAttribute("ticketList_bookingNo", ticketList_bookingNo);
        

        // ticketNO 받아서 qr 발행

        rttr.addFlashAttribute("booking", booking);

        return "redirect:/booking/payment_complete";
    }

    // 결제 완료
    @GetMapping(value="/payment_complete")
    public String paymentComplete(Model model, Booking booking) throws Exception {
        log.info("결제완료 booking" + booking);
        
        // int bookingNo = booking.getBookingNo();

        model.addAttribute("booking", booking);


        return "booking/payment_complete";
    }

    // 탑승권 발행
    @GetMapping(value="/ticket")
    public String ticket() {
        return "booking/ticket";
    }

    // 탑승권 상세 페이지
    @PostMapping(value="/ticketInfo")
    public String ticketInfo() {
        return "booking/ticketInfo";
    }





}