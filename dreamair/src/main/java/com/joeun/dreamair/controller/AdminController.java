package com.joeun.dreamair.controller;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 관리자 메인 화면
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

    
    /**
     * 관리자 로그인 화면
     * @return
     */
    @GetMapping(value="/login")
    public String adminlogin(Model model, Principal principal){
        String adminId = principal.getName();
        model.addAttribute("adminId", adminId);
        return "admin_login";
    }

    // /admin/, /admin
    // 관리자 권한(ROLE_ADMIN)을 가진 사용자만 접근 허용
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping(value={"/", ""})
    public String index() {
        log.info("[GET] - /admin");
        return "admin/index";
    }

    /**
     * 
     */

}
