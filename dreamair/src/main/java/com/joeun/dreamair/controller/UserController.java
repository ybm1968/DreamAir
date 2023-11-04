package com.joeun.dreamair.controller;

import java.security.Principal;

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

import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.service.UserService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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
     * 사용자 페이지
     * @return
     */
    // 회원권한(ROLE_USER)을 가진 사용자만 접근 허용
    // @PreAuthorize("hasRole('ROLE_USER')")
    // @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    // @Secured("ROLE_USER")
    @Secured({"ROLE_USER", "ROLE_ADMIN"})
    @GetMapping(value={"/", ""})
    public String index() {
        return "user/index";
    }


    /**
     * 회원정보 수정
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
    
    // /**
    //  * 주문 내역 페이지
    //  * @throws Exception
    //  */
    // @GetMapping(value="/booking")
    // public String booking(Model model, Principal principal, Booking booking) throws Exception {
    //     List<Booking> bookingList = null;
    //     // 회원 주문 내역 데이터 요청
    //     if( principal != null ) {
    //         log.info("회원 : " + principal.getName());
    //         String userId = principal.getName();
    //         bookingList = bookingService.listByUserId(userId);
    //         booking = bookingService.sumBooking(userId);
    //         log.info("booking : " + booking);
    //         model.addAttribute("bookingList", bookingList);
    //         model.addAttribute("booking", booking);
    //     }
        
        

    //     return "user/booking";
    // }


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
    

    @GetMapping(value="/checkin")
    public String checkin(){
    }

    @PostMapping(value="/checkin")
	public ModelAndView seat(SeatDataVO seatDataVO) throws Exception {
		ModelAndView mv = new ModelAndView();
		BookingTicketVO isCheck = new BookingTicketVO();
		int depInsertCheck = 0;
		int arrInsertCheck = 0;
		String depFlightNum = null;
		String arrFlightNum = null;
		String path = "../";
		String msg = "이미 체크인 하셨습니다.";

		String depSeat[] = seatDataVO.getDepSeat().split(",");
		// 가는편 예약하기
		for (int i = 0; i < depSeat.length; i++) {
			int depSeatResult = 0;
			int depUpdateResult = 0;

			String fnum = Integer.toString(seatDataVO.getDepFNum());
			BookingTicketVO depBookingTicketVO1 = new BookingTicketVO();
			depBookingTicketVO1.setBookingNum(seatDataVO.getBookingNum());
			depBookingTicketVO1.setDepFnum(seatDataVO.getDepFNum());
			List<BookingTicketVO> depBookingTicketVOs = seatService.getDepBnum(depBookingTicketVO1);
			SeatVO depSeatVO = new SeatVO();
			BookingTicketVO depBookingTicketVO2 = new BookingTicketVO();
			depBookingTicketVO2.setBnum(depBookingTicketVOs.get(i).getBnum());
			depBookingTicketVO2.setFlightBNum(seatService.flightNum(seatService.getVihicleId(fnum)));
			depBookingTicketVO2.setDepFnum(seatDataVO.getDepFNum());
			depBookingTicketVO2.setBookingNum(seatDataVO.getBookingNum());
			depSeatVO.setBookingNum(seatDataVO.getBookingNum());
			depSeatVO.setFnum(seatDataVO.getDepFNum());
			depSeatVO.setFlightNum(depBookingTicketVO2.getFlightBNum());
			depSeatVO.setSeatName(depSeat[i]);
			depSeatResult = seatService.seatBook(depSeatVO);
			depUpdateResult = seatService.updateFlightNumDep(depBookingTicketVO2);
			if (depSeatResult + depUpdateResult == 2)
				depInsertCheck++;
			depFlightNum = depBookingTicketVO2.getFlightBNum();
		}
		if (seatDataVO.getArrSeat() != null) { // 편도비행기가 아니라면
			// 오는편 예약하기
			String arrSeat[] = seatDataVO.getArrSeat().split(",");
			for (int j = 0; j < arrSeat.length; j++) {
				int arrSeatResult = 0;
				int arrUpdateResult = 0;
				String fnum2 = Integer.toString(seatDataVO.getArrFNum());
				BookingTicketVO arrBookingTicketVO1 = new BookingTicketVO();
				arrBookingTicketVO1.setBookingNum(seatDataVO.getBookingNum());
				arrBookingTicketVO1.setDepFnum(seatDataVO.getArrFNum());
				List<BookingTicketVO> arrbookingTicketVOs = seatService.getDepBnum(arrBookingTicketVO1);
				SeatVO arrSeatVO = new SeatVO();
				BookingTicketVO arrBookingTicketVO2 = new BookingTicketVO();
				arrBookingTicketVO2.setBnum(arrbookingTicketVOs.get(j).getBnum());
				arrBookingTicketVO2.setFlightBNum(seatService.flightNum(seatService.getVihicleId(fnum2)));
				arrBookingTicketVO2.setDepFnum(seatDataVO.getArrFNum());
				arrBookingTicketVO2.setBookingNum(seatDataVO.getBookingNum());
				arrSeatVO.setBookingNum(seatDataVO.getBookingNum());
				arrSeatVO.setFnum(seatDataVO.getArrFNum());
				arrSeatVO.setFlightNum(arrBookingTicketVO2.getFlightBNum());
				arrSeatVO.setSeatName(arrSeat[j]);
				arrSeatResult = seatService.seatBook(arrSeatVO);
				arrUpdateResult = seatService.updateFlightNumDep(arrBookingTicketVO2);
				if (arrSeatResult + arrUpdateResult == 2)
					arrInsertCheck++;
			}
		} else {
			System.out.println("편도비행기");
		}
		if (seatDataVO.getArrSeat() != null) { // 왕복 비행기 데이터 입력 여부 확인
			if (depInsertCheck == seatDataVO.getPeople() && arrInsertCheck == seatDataVO.getPeople()) {
				msg = "체크인 완료";
				// path = "./seatQr?depFlightNum=" + depFlightNum + "&arrFlightNum=" +
				// arrFlightNum;
			} else {
				msg = "체크인 실패";
				path = "./test";
			}
		} else { // 편도 비행기 데이터 입력 여부 확인
			if (depInsertCheck == seatDataVO.getPeople()) {
				msg = "체크인 완료";
				// path = "./seatQr?depFlightNum=" + depFlightNum;
			} else {
				msg = "체크인 실패";
				path = "./test";
			}
		}
		mv.addObject("msg", msg);
		mv.addObject("path", path);
		mv.setViewName("common/common_result");
		return mv;

	}
    
    
    
}
