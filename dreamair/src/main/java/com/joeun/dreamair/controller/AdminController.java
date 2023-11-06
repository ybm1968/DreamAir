package com.joeun.dreamair.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.service.AdminService;
import com.joeun.dreamair.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    // @Autowired
    // private UserService userService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

     @Autowired
    private PasswordEncoder passwordEncoder;        // 비밀번호 암호화 객체 

   // /admin/, /admin
//    관리자 권한(ROLE_ADMIN)을 가진 사용자만 접근 허용
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value={"/", ""})
    public String index() {
        log.info("[GET] - /admin");
        return "admin/index";
    }

    // [관리자] index 화면 
    // @GetMapping(value={"/"})
    // public String index() {
    //     return "/admin/index";
    // }
    
    // 관리자 목록 조회
    @GetMapping(value="/admin_list")
    public String adminlist(Model model) throws Exception {
        log.info("[GET] - /admin/admin_list");

        List<Admin> list = adminService.admin_list();
        model.addAttribute("AdminList", list);

        return "/admin/admin_list";
    }

    // 관리자 등록
    @GetMapping(value="/admin_insert")
    public String adminInsert() {
        return "admin/admin_insert";
    }

    // 관리자 등록 처리
    @PostMapping(value="/admin_insert")
    public String adminInsertPro(Admin admin, HttpServletRequest request) throws Exception {
        int result = adminService.admin_insert(admin);

        if(result > 0 ){
            log.info("관리자 등록 성공");
            return "redirect:/admin/index";
        }
    return "redirect:/admin/admin_insert";
    }

    // //관리자 로그인 화면
    // @GetMapping(value="/admin_login")
    // public String adminLogin(@CookieValue(value = "remember-id", required = false) Cookie cookie, Model model) {
    //     String adminId = "";
    //     boolean rememberId = false;
    //     if( cookie != null ) {
    //         log.info("CookieName : " + cookie.getName());
    //         log.info("CookiValue : " + cookie.getValue());
    //         adminId = cookie.getValue();
    //         rememberId = true;
    //     }

    //     model.addAttribute("adminId", adminId);
    //     model.addAttribute("rememberId", rememberId);

    //     return "admin/admin_login";
    // }

    // // 사용자 목록 조회
    //  @GetMapping(value="/user_list")
    //     public String users(Model model) throws Exception {
    //     List<Member> userList = memberService.user_list();
    //     model.addAttribute("UserList", userList);
    //     return "admin/user_list";
    // }

    // @PostMapping(value="/users")
    // public String usersPost(UserAuth userAuth) throws Exception {
    //     log.info(userAuth.toString());
    //     int result = userAuthService.insert(userAuth);
    //     return "redirect:/admin/users";
    // }
    
    
    // @DeleteMapping(value="/users")
    // public ResponseEntity<String> usersDelete(UserAuth userAuth) throws Exception {
    //     log.info(userAuth.toString());
    //     int result = userAuthService.deleteByUserIdAndAuth(userAuth);
    //     return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    // }

    //     /* 메인페이지 로그아웃 */
    // @GetMapping(value="/logout")
    // public String logoutMainGET(HttpServletRequest request) throws Exception{
    //     log.info("logoutMainGET메서드 진입");
        
    //     HttpSession session = request.getSession();
        
    //     session.invalidate();
        
    //     return "redirect:/";  
    // }

    
    // // [사용자 관리]
    // // 사용자 목록 조회
    @GetMapping(value="/user_list")
    public String userlist(Model model) throws Exception {
        log.info("[GET] - /admin/user_list");

        List<Users> list = adminService.user_list();
        model.addAttribute("UserList", list);

        return "/admin/user_list";
    }

    // 사용자 수동 등록     
    @GetMapping(value="/user_insert")
    public String userInsert() {
        return "admin/user_insert";
    }

    // // 사용자 정보 수정
    //  @GetMapping(value="/user_insert/{userNo}")
    //  public String userUpdate(@PathVariable("userNo") int userNo, Model model) throws Exception {
           
    //     model.addAttribute("Users", adminService.user_update(userNo));
                    
    //     return "admin/user_update";
    //  }

    // // 사용자 정보 수정 처리   
    // @PostMapping(value="/user_update")
    // public String userUpdatePro(@ModelAttribute Users users) throws Exception {
    //     int result = adminService.user_insert(users);
    //     if( result == 0 ) return "redirect:/admin/user_update";

    //     return "redirect:/admin/user_list";
    // }
    
    // // 사용자 정보 삭제 처리      
    // @GetMapping(value="/user_delete")
    // public String userDelete(@RequestParam int userNo) throws Exception {
    //     adminService.user_delete(userNo);
    //     return "redirect:/admin/user_list";
    // }
    
    // [예매 관리]
    // 예매 목록 조회
    @GetMapping(value="/booking_list")
    public String bookinglist(Model model) throws Exception {
        log.info("[GET] - /admin/booking_list");

        List<Admin> bookinglist = adminService.booking_list();
        model.addAttribute("BookingList", bookinglist);

        return "/admin/booking_list";
    }

    // [탑승권 관리]
    // 사용자 목록 조회
    @GetMapping(value="/ticket_list")
    public String ticketlist(Model model) throws Exception {
        log.info("[GET] - /admin/ticket_list");

        List<Admin> ticketlist = adminService.ticket_list();
        model.addAttribute("TicketList", ticketlist);

        return "/admin/ticket_list";
    }

    // 탑승 처리
    // @PostMapping(value="ticket_list")
    // public String ticketUsed(@PathVariable("ticketNo") int ticketNo, @PathVariable("final") int isBoarded, Model model) throws Exception {
        
    //     if(isBoarded == 1) { // 탑승 완료

    //     }
    //     model.addAttribute(null, model)
    //     return "redirect:/admin/ticket_list";
    // }

}