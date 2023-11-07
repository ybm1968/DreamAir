package com.joeun.dreamair.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Product;
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
    
    // 관리자 목록 조회
    @GetMapping(value="/admin_list")
    public String adminlist(Model model) throws Exception {
        log.info("[GET] - /admin/admin_list");

        List<Admin> list = adminService.admin_list();
        model.addAttribute("AdminList", list);

        return "admin/admin_list";
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

    // // [사용자 관리]
    // // 사용자 목록 조회
    @GetMapping(value="/user_list")
    public String userlist(Model model) throws Exception {
        log.info("[GET] - /admin/user_list");

        List<Users> userlist = adminService.user_list();
        model.addAttribute("UserList", userlist);

        return "admin/user_list";
    }

    // 사용자 등록
    @GetMapping(value="/user_insert")
    public String userInsert() {
        return "admin/user_insert";
    }

    // 관리자 등록 처리
    @PostMapping(value="/user_insert")
    public String userInsertPro(Users user, HttpServletRequest request) throws Exception {
        int result = adminService.user_insert(user);

        if(result > 0 ){
            log.info("사용자 등록 성공");
            return "redirect:/admin/index";
        }
    return "redirect:/admin/user_insert";
    }

    // 사용자 정보 수정
     @GetMapping(value="/user_insert/{userNo}")
     public String userUpdate(@PathVariable("userId") String userId, int userNo, Model model) throws Exception {
    
        model.addAttribute("Users", adminService.user_update(userNo));
        Users user = userService.selectById(userId);
        
        model.addAttribute("user", user);
            
        return "admin/user_update";
     }

    // 사용자 정보 수정 처리   
    @PostMapping(value="/user_update")
    public String userUpdatePro(@ModelAttribute Users users) throws Exception {
        int result = adminService.user_insert(users);
        if( result == 0 ) return "redirect:/admin/user_update";

        return "redirect:/admin/user_list";
    }
    
    // 사용자 정보 삭제 처리      
    @PostMapping(value="/user_delete")
    public String userDelete(@RequestParam int userNo) throws Exception {
        adminService.user_delete(userNo);
        return "redirect:/admin/user_list";
    }
    
    // [예매 관리]
    // 예매 목록 조회
    @GetMapping(value="/booking_list")
    public String bookinglist(Model model) throws Exception {
        log.info("[GET] - /admin/booking_list");

        List<Booking> bookinglist = adminService.booking_list();
        model.addAttribute("BookingList", bookinglist);

        return "admin/booking_list";
    }

    // [탑승권 관리]
    // 탑승권 목록 조회 화면
    // @GetMapping(value="/ticket_list")
    // public String ticket_list(Model model, Booking ticket, Product product) throws Exception {
    //     log.info("[GET] - /product/ticket_list");
        
        
    //     List<Booking> ticketList = adminService.ticket_list();
    //     model.addAttribute("product", product);
    //     model.addAttribute("TicketList", ticketList);
      
        
    //     return "admin/ticket_list";
    // }

    @GetMapping(value="/ticket_list")
    public String ticket_listPro(Model model, Booking ticket, Product product) throws Exception {
        log.info("[POST] - /product/ticket_list");

        // today : YYYY/MM/DD (String)
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String today = format.format(now);
        log.info("today : " + today);
        ticket.setDepartureDate(today);
        

        int select  = ticket.getSelect();
        int checkedIn = ticket.getCheckedIn();
        int isBoarded = ticket.getIsBoarded();
        int flightNo = ticket.getFlightNo();

        log.info("flightNo 값 넘어오나 확인 : " + ticket.getFlightNo());
        log.info("select 값 넘어오나 확인 : " + Integer.toString(select));
        log.info("checkeedIn 값 넘어오나 확인 : " + Integer.toString(checkedIn));
        log.info("isBoarded 값 넘어오나 확인 : " + Integer.toString(isBoarded));

        switch (select) {
            case 1: checkedIn = 1; isBoarded = 0; break;
            case 2: checkedIn = 1; isBoarded = 1; break;
        }

        List<Booking> ticketList = null;
        if(select==0){
            // 전체조회
            ticketList = adminService.ticket_list(today);
        } else{
            // 검색
            log.info("검색....");
            ticketList = adminService.ticket_selectList(today, flightNo, checkedIn, isBoarded);
        }

        model.addAttribute("product", product);
        model.addAttribute("TicketList", ticketList);

        return "admin/ticket_list";
    }


    // 항공기 조회    Booking booking = adminMapper.ticket_select(ticketNo);
 
    // 탑승 처리
    // @PostMapping(value="ticket_list")
    // public String ticketUsed(@PathVariable("ticketNo") int ticketNo, @PathVariable("final") int isBoarded, Model model) throws Exception {
        
    //     if(isBoarded == 1) { // 탑승 완료

    //     }
    //     model.addAttribute(null, model)
    //     return "redirect:/admin/ticket_list";
    // }

}