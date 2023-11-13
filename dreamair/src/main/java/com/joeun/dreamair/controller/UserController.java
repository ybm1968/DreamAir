package com.joeun.dreamair.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService userService;

    // @Autowired
    // private BookingService bookingService;

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;


    /**
     * 마이 페이지
     * @return
     */
    // 회원권한(ROLE_USER)을 가진 사용자만 접근 허용
    // @PreAuthorize("hasRole('ROLE_USER')")
    // @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    // @Secured("ROLE_USER")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(value={"/", ""})
    public String index() {
        // int result = 10 / 0;
        // log.info(result + "");
        return "user/index";
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
            
            userService.delete(loginId);
            
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
    public String viewMileage(Users user, Model model, Principal principal) throws Exception {
        String loginId = principal != null ? principal.getName() : null;

        user = userService.selectById(loginId);
        
        Users mileageUser = userService.selectMileage(loginId);
        user.setMileage(mileageUser.getMileage());

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
    @GetMapping(value="/checkIn")
    public String checkin(Model model, Principal principal) throws Exception {
        String loginId = principal != null ? principal.getName() : null;

        Users user = userService.selectById(loginId);

        model.addAttribute("user", user);

        return "user/checkIn";
    }


    /**
     * 주문 내역 페이지
     * @throws Exception
     */
    @GetMapping(value="/booking")
    public String booking(Model model, Principal principal, Booking booking) throws Exception {
        List<Booking> bookingList = null;
        // 회원 주문 내역 데이터 요청
        if( principal != null ) {
            log.info("회원 : " + principal.getName());
            String userId = principal.getName();
            // bookingList = bookingService.listByUserId(userId);
            // booking = bookingService.sumBooking(userId);
            log.info("booking : " + booking);
            model.addAttribute("bookingList", bookingList);
            model.addAttribute("booking", booking);
        }
        
        return "user/booking";
    }


    // @PostMapping(value="/booking")
    // public String bookingPost(Model model, Principal principal, Booking booking) throws Exception {
    //     List<Booking> bookingList = null;
    //     // 비회원 주문 내역 데이터 요청
    //     // ✅ 비회원 전화번호           - phone
    //     // ✅ 비회원 주문 비밀번호      - bookingPw
    //     if( principal == null && booking.getPhone() != null ) {
    //         log.info("비회원 : " + booking.getPhone());
    //         bookingList = bookingService.listByGuest(booking);
    //         booking = bookingService.sumBookingByGuest(booking);
    //         model.addAttribute("bookingList", bookingList);
    //         model.addAttribute("booking", booking);
    //     }
    //     return "user/booking";
    // }
    

    
    
    
}


