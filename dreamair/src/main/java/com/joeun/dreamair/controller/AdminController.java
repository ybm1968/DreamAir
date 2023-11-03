package com.joeun.dreamair.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;
    
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

    // @GetMapping(value={"/", ""})
    // public String index() {

    //     return "admin/index";
    // }

    // 로그인 화면
    @GetMapping(value="/admin_login")
    // public String login(Model model, Principal principal) {
    public String login() {
    
    //    String adminId = principal != null ? principal.getName() : "";
    //    log.info("adminId : " + adminId);
    //    model.addAttribute("userId", adminId);

      return "admin/admin_login";	
   }

   // 로그인 처리
   @PostMapping(value="/admin_login")
    public String loginPro(Model model, Admin admin, HttpServletRequest request) throws Exception {

     String adminId = request.getParameter("adminId");
	 String adminPw = request.getParameter("adminPw");
        log.info("adminId : " + adminId);
        log.info("adminPw : " + adminPw);
    admin.setAdminId(adminId);
     admin.setAdminPw(adminPw);


    Admin adminLogin = adminService.admin_login(adminId, adminPw);


    if(adminLogin == null) {
        return "redirect:/admin/admin_login";
    }

	// 로그인 성공 : 세션에 아이디 등록
    //model.addAttribute("admin", admin);
    model.addAttribute("adminId", adminId);

    return "redirect:/admin/index";	
   }


    // 관리자 목록 조회
    
    /**
     * 관리자 등록 화면
     * @param param
     * @return
     */
    @GetMapping(value="/admin_insert")
    public String adminInsert() {
        return "admin/admin_insert";
    }

    /**
     * 관리자 등록 처리
     * @param user
     * @return
     * @throws Exception
     */
    // @PostMapping(value="/admin_insert")
    // public String adminInsertPro(Admin admin, HttpServletRequest request) throws Exception {
    //     int result = adminService.admin_insert(admin);

    //     if( result > 0 ) {  
    //         log.info("관리자 등록 성공");
    //     }

    //     return "redirect:/index";
    // }

    
    /**
     * 사용자 수동 등록
     */
     @GetMapping(value="/user_insert")
     public String user_insert() {
        return "admin/user_insert";
     }

    /**
     *  회원 관리
     * @throws Exception
    */
    @GetMapping(value="/user_list")
    public String user_list(Model model) throws Exception {
        List<Users> list = adminService.user_list();
        model.addAttribute("userList", list);
        return "/admin/user_list";
    }

    
    /**
     * 회원 정보 수정
     * @param param
     * @return
     * @throws Exception
     */
    @GetMapping(value="/user_update")
    public String userUpdate(Model model, Principal principal) throws Exception {
        String loginId = principal != null ? principal.getName() : null;

        Users user = userService.selectById(loginId);
        
        model.addAttribute("user", user);

        return "admin/user_update";
    }
    

}
