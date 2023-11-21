package com.joeun.dreamair.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joeun.dreamair.dto.Board;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.service.BoardService;
import com.joeun.dreamair.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private BoardService boardService;

    /**
     * 메인 화면
     * @param model
     * @param principal
     * @return
     * @throws Exception
     */
    @GetMapping(value={"", "/"})
    public String home(Model model, Principal principal) throws Exception {
        // Principal : 현재 로그인한 사용자의 정보를 확인하는 인터페이스
        String loginId = principal != null ? principal.getName() : "guest";
        // String loginId = principal.getName();
        model.addAttribute("loginId", loginId);

        // 최근 게시글 목록
        List<Board> boardMainList = boardService.mainList();  // 수정된 부분
        log.info("최근 게시글 개수 : " + boardMainList.size());
        for (Board board : boardMainList) {
            log.info("게시글 정보 : " + board);
        }

        model.addAttribute("mainList", boardMainList);
        
        return "index";
    }
    

    /**
     * 로그인 화면
     * @return
     */
    @GetMapping(value="/login")
    public String login(@CookieValue(value = "remember-id", required = false) Cookie cookie, Model model) {
        // @CookieValue(value="쿠키명", required=필수여부)
        // - required=true (defalut)     : 쿠키를 필수로 가져옴 ➡ 쿠키가 없으면 에러 
        // - required=false              : 쿠키 필수 ❌ ➡ 쿠키가 없어도 에러❌ (null)
        String userId = "";
        boolean rememberId = false;
        if( cookie != null ) {
            log.info("CookieName : " + cookie.getName());
            log.info("CookiValue : " + cookie.getValue());
            userId = cookie.getValue();
            rememberId = true;
        }

        model.addAttribute("userId", userId);
        model.addAttribute("rememberId", rememberId);
        
        return "login";
    }


    /**
     * 회원 가입 화면
     * @param param
     * @return
     */
    @GetMapping(value="/join")
    public String join() {
        return "join";
    }

    
    /**
     * 회원 가입 처리
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping(value="/join")
    public String joinPro(Users user, HttpServletRequest request) throws Exception {
        int result = userService.insert(user);

        // 회원 가입 성공 시, 바로 로그인
        if( result > 0 ) {  
            userService.login(user, request);
        }

        return "redirect:/";
    }


    /**
     * 접근 거부 에러 페이지
     * @param param
     * @return
     */
    @GetMapping(value="/exception")
    public String error(Authentication auth, Model model) { // 보통 에러 페이지는 접근 권한이 없어 거부되거나 하는 경우에 오는 페이지니까 model에 객체로 어쩌구..
        log.info(auth.toString());
        model.addAttribute("msg", "인증 거부 : " + auth.toString());
        return "exception";
    }
    
    @ResponseBody /* return되는 값은 view의 주소가 아닌 데이터임을 나타내는 어노테이션 */
	@RequestMapping(value = "/idCheck", method = RequestMethod.POST)
	public int idCheck(Users user) {
		
		String userid = user.getUserId();
        int result = 0;
		//int result = userService.idCheck(userid); //userMapper
		/* 만약, DB에 ID가 존재하면 1을, 존재하지 않으면 0을 return 할 것임 */
		return result;
	}   
    
}
