package com.joeun.dreamair.controller;

import java.security.Principal;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
    
  @Autowired
  private UserService userService;

  /**
   * 메인 화면
   * @param model
   * @param principal
   * @return
   */
  @GetMapping(value={"", "/"})
  public String home(Model model, Principal principal){
    String loginId = principal != null ? principal.getName() : "guest";
    model.addAttribute("loginId", loginId);

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
    public String error(Authentication auth, Model model) {
        log.info(auth.toString());
        model.addAttribute("msg", "인증 거부 : " + auth.toString());
        return "exception";
    }
    

    // //////////////////test
    // /**
    //  * 로그인 폼을 거치지 않고 바로 로그인
    //  * @param username
    //  * @return
    //  */
    // @RequestMapping("/loginWithoutForm/{username}")
    //     public String loginWithoutForm(@PathVariable(value="username") String username) {

    //     List<GrantedAuthority> roles = new ArrayList<>(1);
    //     String roleStr = username.equals("admin") ? "ROLE_ADMIN" : "ROLE_GUEST";
    //     roles.add(new SimpleGrantedAuthority(roleStr));

    //     Users user = new Users(username, "", roles);

    //     Authentication auth = new UsernamePasswordAuthenticationToken(user, null, roles);
    //     SecurityContextHolder.getContext().setAuthentication(auth);

    //     if(username.equals("admin")){
    //         return "redirect:/admin";
    //     }
    // return "redirect:/";
    // }
  
}
