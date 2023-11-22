package com.joeun.dreamair.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.service.AdminService;
import com.joeun.dreamair.service.BookingService;
import com.joeun.dreamair.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private BookingService bookingService;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;


    /**
     * 마이 페이지
     * @return
     */
    // 회원권한(ROLE_USER)을 가진 사용자만 접근 허용
    // @PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    // @Secured("ROLE_USER")
    // @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(value={"/", ""})
    public String index() {
        // int result = 10 / 0;
        // log.info(result + "");
        return "user/index";
    }

    /**
     * 장바구니 페이지
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/cart")
    public String cart(Model model, Principal principal, Users user) throws Exception {

        String loginId = principal != null ? principal.getName() : "GUEST";
        
        String phone = "";
        String userPw = "";

        // 회원 번호 추출
        user = userService.selectById(loginId);
        int userNo = user.getUserNo();

        // 비회원 번호 추출 - 연락처, 비밀번호 정보 저장
        int userNo2 = 0;
        if(loginId.equals("GUEST")){
            return "user/addCart";
        }

        // 회원이 가지고 있는 장바구니 조회
        List<Users> cartlist = userService.user_cart_list(userNo);

        log.info("카트 리스트 : " + cartlist);
        model.addAttribute("CartList", cartlist);

            return "user/addCart";
    }

    // @PostMapping("/cart")
    // public String CartPro(Product product, Users user, Booking booking) throws Exception {
    //     int result = 0;
    //     // double sum = cartList.stream().mapToDouble(Cart::getProductPrice).sum();

    //     // model.addAttribute("CartList", cartList);
    //     // model.addAttribute("sum", sum);
    //     List<Users> CartList = new ArrayList<Users>(); 
    //     int productNo = product.getProductNo();
    //     int productPrice = product.getProductPrice();
    //     int cartCnt = 0;
    //     int sum = 0;

    //     for(int i =0; i<CartList.size(); i++){
    //         sum += productPrice;
    //     }
    //     // 회원일 경우
    //     // userNo에 productNo를 cart 테이블에 데이터 저장
        
    //     // 비회원일 경우
    //     // input box를 통해 phone이랑 password를 입력 받고,
    //     // 장바구니 table에 데이터 저장

    //     return "";
    // }

    // 장바구니 삭제 처리
    @PostMapping(value="/cart_delete")
    public String cartDelete(int cartNo) throws Exception {
        log.info("[POST] - /user/cart_delete");

        int result = userService.cart_delete(cartNo);
        if(result == 0) return "redirect:/user/addCart?cartNo=" + cartNo;
        return "redirect:/user/cart";
    }

    @GetMapping(value="/addCart")
    public String addCart() {

        return "";
    }

    /**
     * 회원정보 수정 페이지
     * @param param
     * @return
     * @throws Exception
     */
    @GetMapping(value="/update")
    public String userUpdate(Model model, Principal principal) throws Exception {
        String loginId = principal != null ? principal.getName() : null;

        Users user = userService.selectById(loginId);
        
        model.addAttribute("user", user);

        return "user/update";
    }
    

    /**
     * 회원정보 수정 처리
     * @param entity
     * @return
     * @throws Exception
     */
    @PostMapping(value="/update")
    public String updateUpdatePro(Users user
                                , HttpServletRequest request
                                , HttpServletResponse response) throws Exception {
        log.info("user : " + user);
        int result = userService.update(user);

        // 회원정보 수정 실패
        if( result == 0 ) {
            return "redirect:/user/update";
        }
        
        // HttpSession session = request.getSession();
        // session.invalidate();       // 세션 무효화(로그아웃)

        // 시큐리티 강제 로그아웃
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        new SecurityContextLogoutHandler().logout(request, response, authentication);

        // remember-me 쿠키 삭제
        Cookie cookie = new Cookie("remember-me", "");     
        cookie.setMaxAge(0);                                  
        cookie.setPath("/");        
        response.addCookie(cookie);

        // 토큰 삭제
        persistentTokenRepository.removeUserTokens(user.getUserId());

        // 로그아웃 후 ➡ 로그인 페이지
        return "redirect:/login";
    }


    /**
     * 회원 탈퇴 페이지
     * @param param
     * @return
     * @throws Exception
     */
    @GetMapping(value="/delete")
    public String userDelete(Model model, Principal principal) throws Exception {
        String loginId = principal != null ? principal.getName() : null;

        Users user = userService.selectById(loginId); 

        model.addAttribute("user", user);

        return "user/delete";
    }
    

    /**
     * 회원 탈퇴 처리
     * @param principal
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/delete")
    public String userDeleteProcess(Model model
                                    ,Principal principal
                                    ,Users user
                                    , HttpServletRequest request
                                    , HttpServletResponse response) throws Exception {

        String loginId = principal != null ? principal.getName() : null;

        try {
            
            userService.deleteUsers(loginId);
            userService.deleteAuth(loginId);
            userService.deleteMileage(loginId);
            
            // 시큐리티 강제 로그아웃
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            
            log.info("test1");
            
            // remember-me 쿠키 삭제
            Cookie cookie = new Cookie("remember-me", "");     
            cookie.setMaxAge(0);                                  
            cookie.setPath("/");        
            response.addCookie(cookie);
            
            log.info("test2");
            
            // 토큰 삭제
            persistentTokenRepository.removeUserTokens(user.getUserId());
            
            log.info("test3");
            

            
        } catch (Exception e) {

            System.out.println("예외쓰~~~~~~~~~~~~~~");
            
            return "index";
        }
        
        return "redirect:/";
    }
    

    /**
     * 회원 마일리지 조회 페이지
     * @param user
     * @param model
     * @param principal
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/mileage")
    public String viewMileage(Users user, Product product, Model model, Principal principal) throws Exception {
        String loginId = principal != null ? principal.getName() : null;

        user = userService.selectById(loginId);
        
        Users mileageUser = userService.selectMileage(loginId);

        double mileage = (product.getProductPrice() * 0.1);

        user.setMileage(mileage);

        System.out.println(user);

        model.addAttribute("user", user);

        return "user/mileage";
    }
    
    /**
     * 회원 체크인 페이지
     * @param param
     * @return
     * @throws Exception
     */
    @GetMapping(value="/checkin")
    public String checkin(Model model, Principal principal) throws Exception {
        String loginId = principal != null ? principal.getName() : "GUEST";

        Users user = userService.selectById(loginId);
        model.addAttribute("user", user);

        return "user/checkin";
    }

    // 체크인 처리
    @PostMapping(value="/checkin")
    public String checkinPro(@RequestParam int ticketNo, Model model, Booking booking, RedirectAttributes rttr) throws Exception {
        log.info("ticketNo : "  + ticketNo );
        // 입력받은 탑승권 번호를 조회

       List<Booking> ticketList = adminService.pas_ticketList(ticketNo);
       log.info("ticketList : " + ticketList);
       log.info("ticket.size() " + ticketList.size());
    //    model.addAttribute("TicketList", ticketList);
       rttr.addFlashAttribute("TicketList", ticketList);     

    //    int checkedIn = booking.getCheckedIn();
    //    log.info("checkedIn 값 : " + checkedIn);

    //    rttr.addFlashAttribute("booking", booking);

       return "redirect:/user/checkin";
    }

    // 체크인 완료 페이지
    // @GetMapping(value="/checkin_complete")
    // public String checkinComplete(Model model, Booking booking) throws Exception {
    //     log.info("왔니?");
    //     return "user/checkin_complete";
    // }
 
    @GetMapping(value="/checkin_complete")
    public String checkincomplete(Model model, Booking booking){
        log.info("[GET]] - /user/checkin_complete");
        model.addAttribute("booking", booking);
        return "user/checkin_complete";
    }

    @PostMapping(value="/checkin_complete")
    public String checkinpro(@RequestParam int ticketNo, Booking booking, Model model) throws Exception {
        log.info("[POST]] - /user/checkin_complete");

        int checkedIn = 1;
        // int isBoarded = 0;
        booking.setCheckedIn(checkedIn);
        // booking.setIsBoarded(isBoarded);
        model.addAttribute("booking", booking);

        int result = adminService.ticket_update_c(ticketNo, checkedIn);
        if(result > 0){
            log.info("DB 변경 완료");
        }

        return "redirect:/user/checkin_complete";
    }

    // 충돌나면 여기 아래로 적용 필요!
    /**
     * 예매 내역 페이지 - 회원
     * @throws Exception
     */
    @GetMapping(value="/bookingList")
    public String bookingList(Model model, Principal principal, Booking booking) throws Exception {
        List<Booking> bookingList = null;
        // 회원 주문 내역 데이터 요청
        if( principal != null ) {
            log.info("회원 : " + principal.getName());
            String userId = principal.getName();
            
            bookingList = bookingService.selectBookingListByUser(userId);
            
            // ticket = ticketService.sumBooking(userId);
            
            // log.info("ticket : " + ticketList);

            model.addAttribute("bookingList", bookingList);
            // model.addAttribute("booking", booking);
        }
        
        return "user/bookingList";
    }


    /**
     * 예매 내역 페이지 - 비회원
     * @throws Exception
     */
    @PostMapping(value="/bookingList")
    public String bookingPost(Model model, Principal principal, Booking booking) throws Exception {
        List<Booking> bookingList = null;
        // 비회원 주문 내역 데이터 요청
        // ✅ 비회원 전화번호           - phone
        // ✅ 비회원 주문 비밀번호      - bookingPw
        if( principal == null && booking.getPhone() != null ) {
            log.info("비회원 : " + booking.getPhone());
            // bookingList = bookingService.listByGuest(booking);
            // booking = bookingService.sumBookingByGuest(booking);
            model.addAttribute("bookingList", bookingList);
            model.addAttribute("booking", booking);
        }
        return "user/bookingList";
    }
    
    // 전체 항공편 조회
    @GetMapping(value="/productFlightList")
    public String list(Model model) throws Exception {

        List<Product> productFlightList = userService.product_flightList();
        model.addAttribute("productFlightList", productFlightList);

        return "user/productFlightList";
    }

    /**
     * 티켓 상세 정보 페이지
     * @param bookingNo
     * @param model
     * @return
     * @throws Exception
     */
    @PostMapping(value="/booking/ticketInfo") // URL 경로에 {bookingNo} 변수가 포함되어서 bookingNo 파라미터로 전달받음
    public String viewTicket(@RequestParam int bookingNo, Model model, Principal principal) throws Exception {

        String userId = principal.getName();

        List<Booking> viewTicketDetail = bookingService.selectTicket(bookingNo);
        Users userInfo = userService.selectById(userId);

        log.info("viewTicketDetail : " + viewTicketDetail);
        log.info("user : " + userInfo);
        
        // viewTicket을 모델에 추가
        model.addAttribute("viewTicketDetail", viewTicketDetail);
        model.addAttribute("userInfo", userInfo);
    

        return "/user/booking/ticketInfo"; // 보여줄 뷰 페이지 이름을 반환
    }
}