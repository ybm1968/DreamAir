package com.joeun.dreamair.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
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
    
    /**
     * 관리자
     * @param model
     * @param principal
     * @return
     */
    @GetMapping(value={"/"})
    public String home(Model model, Principal principal) {
        // Principal : 현재 로그인한 사용자의 정보를 확인하는 인터페이스
        String loginId = principal != null ? principal.getName() : "admin";
        // String loginId = principal.getName();

        model.addAttribute("loginId", loginId);

        return "index";
    }

    // /**
    //  * 관리자 로그인 화면
    //  * @return
    //  */
    // @GetMapping(value="/login")
    // public String adminlogin(Model model, Principal principal){
    //     String adminId = principal.getName();
    //     model.addAttribute("adminId", adminId);
    //     return "admin_login";
    // }

    // /admin/, /admin
    // 관리자 권한(ROLE_ADMIN)을 가진 사용자만 접근 허용
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value={"/", ""})
    public String index() {
        log.info("[GET] - /admin");
        return "admin/index";
    }

    /**
     * 관리자 등록 화면
     * @param param
     * @return
     */
    @GetMapping(value="/admin_insert")
    public String insert() {
        return "insert";
    }

    /**
     * 관리자 등록 처리
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping(value="/admin_insert")
    public String insertPro(Admin admin, HttpServletRequest request) throws Exception {
        int result = adminService.insert(admin);

        // 관리자 등록 성공
        if( result > 0 ) {  
            log.info("관리자 등록 성공");
        }

        return "redirect:/";
    }

    /**
     * 사용자 수동 등록
     */
     @GetMapping(value="/user_insert")
     public String user_insert() {
        return "admin/user_insert";
     }

    /**
     *  회원 관리
    */
    @GetMapping(value="/user_list")
    public String user_list() {
        return "admin/user_list";
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
