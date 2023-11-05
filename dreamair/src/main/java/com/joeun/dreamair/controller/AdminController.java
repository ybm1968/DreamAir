package com.joeun.dreamair.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.service.AdminService;
import com.joeun.dreamair.service.MemberService;

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
    private MemberService memberService;
    
     @Autowired
    private PasswordEncoder passwordEncoder;        // 비밀번호 암호화 객체 
    // /**
    //  * 관리자
    //  * @param model
    //  * @param principal
    //  * @return
    //  */
   
   // /admin/, /admin
   // 관리자 권한(ROLE_ADMIN)을 가진 사용자만 접근 허용
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @GetMapping(value={"/", ""})
    // public String index() {
    //     log.info("[GET] - /admin");
    //     return "admin/index";
    // }

    // [관리자] index 화면 
    @GetMapping(value={"/"})
    public String index() {
        return "admin/index";
    }
    
    // @PostMapping
    // public String loginPOST(HttpServletRequest request, Admin admin, RedirectAttributes rttr) throws Exception{
    //    HttpSession session = request.getSession();
    //    Admin admin1 = adminService.admin_login(admin);
       
    //    if(admin1 == null) {                                // 일치하지 않는 아이디, 비밀번호 입력 경우
            
    //     int result = 0;
    //     rttr.addFlashAttribute("result", result);
    //     return "redirect:/admin/admin_login";
        
    // }
    
    // session.setAttribute("member", admin1);             // 일치하는 아이디, 비밀번호 경우 (로그인 성공)
    
    // return "redirect:/admin/index";
    // }
   // 로그인 처리
//    @PostMapping(value="/admin_login")
//     public String loginPro(Model model, Admin admin, HttpServletRequest request) throws Exception {
//         String adminId = request.getParameter("adminId");
//         String adminPw = request.getParameter("adminPw");

//         log.info("adminId : " + adminId);
//         log.info("adminPw : " + adminPw);

//         admin.setAdminId(adminId);
//         admin.setAdminPw(adminPw);

//         Admin adminLogin = adminService.admin_login(adminId, adminPw);

//         // 로그인 실패 시 -> 로그인 화면으로 이동
//         if(adminLogin == null) {
//             return "redirect:/admin/admin_login";
//         }

//         // 로그인 성공 시 -> 세션에 아이디 등록
//         //model.addAttribute("admin", admin);
//         model.addAttribute("adminId", adminId);

//     return "redirect:/admin/index";	
//    }

    // 관리자 목록 조회
    @GetMapping(value="/admin_list")
    public String userlist(Model model) throws Exception {
        log.info("[GET] - /admin/admin_list");

        List<Admin> list = adminService.admin_list();
        model.addAttribute("AdminList", list);

        return "/admin/admin_list";
    }

    // 관리자 등록
    @GetMapping(value="/admin_insert")
    public String adminInsert() {
        return "/admin/admin_insert";
    }

    // 관리자 등록 처리
    @PostMapping(value="/admin_insert")
    public String adminInsertPro(@ModelAttribute Admin admin, HttpServletRequest request, Model model) throws Exception {
        log.info("[POST] - admin/admin_insert]");

        // 폼 데이터를 처리
        String adminId = "";
        String adminPw = "";
        String adminPwCheck = "";  // 암호화
        // String adminId = request.getParameter("adminId");
        // String adminPw = request.getParameter("adminPw");

        adminPw = admin.getAdminPw();
        adminPwCheck = passwordEncoder.encode(adminPw);
        admin.setAdminPw(adminPwCheck);

        log.info("adminId" + adminId);
        log.info("adminPw" + adminPw);

        int result = adminService.admin_insert(admin);
        if( result == 0 ) return "redirect:/admin/admin_insert";
    return "redirect:/admin/index";
    }

  


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
    // @GetMapping(value="/user_list")
    // public String userlist(Model model) throws Exception {
    //     log.info("[GET] - /admin/user_list");

    //     List<Users> list = adminService.user_list();
    //     model.addAttribute("UserList", list);

    //     return "/admin/user_list";
    // }

    // // 사용자 수동 등록     
    // @GetMapping(value="/user_insert")
    // public String userInsert(@ModelAttribute Users users) {
    //     return "admin/user_insert";
    // }

    // // 사용자 수동 등록 처리 
    // @PostMapping(value="/user_insert")
    // public String userInsertPro(@ModelAttribute Users users) throws Exception {
    //     int result = adminService.user_insert(users);
    //     if( result == 0 ) return "redirect:/admin/user_insert";
    //      return "redirect:/admin/user_list";
    //  } 

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
