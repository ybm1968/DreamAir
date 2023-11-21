package com.joeun.dreamair.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Files;
import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.dto.QR;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.service.AdminService;
import com.joeun.dreamair.service.FileService;
import com.joeun.dreamair.service.QRService;
import com.joeun.dreamair.service.UserService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private FileService fileService;

    @Autowired
    private QRService qrService;

    // 관리자 권한(ROLE_ADMIN)을 가진 사용자만 접근 허용
    // @PreAuthorize("hasRole('ROLE_ADMIN')")
    // @GetMapping(value={"/", ""})
    // public String index() {
    //     log.info("[GET] - /admin");
    //     return "admin/index";
    // }

    // [관리자] index 화면 
    @GetMapping(value={"/", ""})
    public String index() {
        log.info("[GET] - /admin/");
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
        log.info("[GET] - /admin/admin_insert");

        return "admin/admin_insert";
    }

    // 관리자 등록 처리
    @PostMapping(value="/admin_insert")
    public String adminInsertPro(Admin admin, HttpServletRequest request) throws Exception {
        log.info("[POST] - /admin/admin_insert");

        int result = adminService.admin_insert(admin);

        if(result > 0 ){
            log.info("관리자 등록 성공");
            return "redirect:/admin/";
        }

        return "redirect:/admin/admin_insert";
    }

    // 관리자 정보 삭제 처리
    @PostMapping(value="/admin_delete")
    public String adminDelete(int adminNo) throws Exception {
        log.info("[POST]] - /admin/admin_delete");
        log.info("adminNo 넘어 왔냐 : " + adminNo);

        adminService.admin_delete(adminNo);

        return "redirect:/admin/admin_list";
    }

    // [사용자 관리]
    // 사용자 목록 조회
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
        log.info("[GET] - /admin/user_insert");

        return "admin/user_insert";
    }

    // 사용자 등록 처리
    @PostMapping(value="/user_insert")
    public String userInsertPro(Users user, HttpServletRequest request) throws Exception {
        log.info("[POST] - /admin/user_insert");

        int result = adminService.user_insert(user);

        if(result > 0 ){
            log.info("사용자 등록 성공");
            return "redirect:/admin/";
        }

        return "redirect:/admin/user_insert";
    }

    // 사용자 정보 수정
     @GetMapping(value="/user_insert/{userNo}")
     public String userUpdate(@PathVariable("userId") String userId, int userNo, Model model) throws Exception {
        log.info("[GET] - /admin/user_insert/{userNo}");

        model.addAttribute("Users", adminService.user_update(userNo));
        Users user = userService.selectById(userId);
        
        model.addAttribute("user", user);
            
        return "admin/user_update";
     }

    // 사용자 정보 수정 처리   
    @PostMapping(value="/user_update")
    public String userUpdatePro(@ModelAttribute Users users) throws Exception {
        log.info("[GET] - /admin/user_update");

        int result = adminService.user_insert(users);
        if( result == 0 ) return "redirect:/admin/user_update";

        return "redirect:/admin/user_list";
    }
    
    // 사용자 정보 삭제 처리      
    @PostMapping(value="/user_delete")
    public String userDelete(@RequestParam int userNo) throws Exception {
        log.info("[POST]] - /admin/user_delete");

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
    // 탑승권 목록 조회
    @GetMapping(value="/ticket_list")
    public String checkTicket(Model model, Product flight, Booking ticket) throws Exception{
        log.info("[GET] - /admin/ticket_list");

        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
        String today = format.format(now);
        log.info("today : " + today);
        ticket.setDepartureDate(today);
        
        int flightNo = ticket.getFlightNo();
        
        List<Booking> ticketList = null;
        ticketList = adminService.ticket_selectList_w(today, flightNo);

        model.addAttribute("TlicketList", ticketList);

        return "admin/ticket_list";
    }

    @PostMapping(value="/ticket_list")
    public String ticket_listPro(Model model, Booking ticket, Product product) throws Exception {
        log.info("[GET] - /product/ticket_list");

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
            ticketList = adminService.ticket_selectList_w(today, flightNo);
        } else{
            // 검색
            log.info("검색....");
            ticketList = adminService.ticket_selectList(today, flightNo, checkedIn, isBoarded);
        }

        model.addAttribute("product", product);
        model.addAttribute("TicketList", ticketList);

        return "redirect:/admin/ticket_list";
    }



    // 탑승권 화면 - 탑승 최종 확인 위한
    @GetMapping(value="/Final_check")
    public String ticket_Checking(Model model, Booking ticket, Files files, QR qr) throws Exception{
        log.info("[GET] - /admin/Final_check");       
        log.info("ticketNo 확인 : " + ticket.getTicketNo());

        int ticketNo = ticket.getTicketNo();
        // ticketNo로 탑승권 조회
        List<Booking> pasTicketList = adminService.pas_ticketList(ticketNo);
        
        files.setParentTable("booking");
        files.setParentNo(ticketNo);
        List<Files> fileList = fileService.listByParent(files);

        qr.setParentTable("booking");
        qr.setParentNo(ticketNo);
        List<QR> qrList = qrService.listByParent(qr);

        model.addAttribute("pasTicketList", pasTicketList);
        model.addAttribute("fileList", fileList);
        model.addAttribute("qrList", qrList);
        
        return "admin/Final_check";
    }

    // 탑승권 처리 - 탑승 최종 확인 위한
    @PostMapping(value="/Final_check")
    public String ticket_CheckingPro(Model model, Booking ticket) throws Exception{
        log.info("[POST] - /admin/Final_check");       

        // ticketNo에 해당하는 정보 조회
        int ticketNo = ticket.getTicketNo();

        // 버튼을 클릭 하면, '탑승 완료'로 처리
        int isBoarded = 1;
        ticket.setIsBoarded(isBoarded);
        model.addAttribute("ticket", ticket);
        int result = adminService.ticket_update_b(ticketNo);
        if(result > 0 ){
            log.info("탑승 완료 DB 처리");
        }
        // 탑승처리가 완료되면 QR 코드 삭제

        return "redirect:/admin/ticket_list";
    }

}