package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.Auth;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.mapper.AdminMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    
  @Autowired
  private AdminMapper adminMapper;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private AuthenticationManager authenticationManager;

  // 관리자 로그인 조회
  // @Override
  // public Admin admin_login(@RequestParam String adminId, @RequestParam String adminPw) throws Exception {
  //   Admin admin = adminMapper.admin_login(adminId, adminPw); 
  //   return admin;
  // }

  // // 사용자 수동 등록
  // @Override
  // public int user_insert(Users users) throws Exception {
  //   int result = adminMapper.user_insert(users);
  //   return result;
  // }

  // // 사용자 정보 수정
  // @Override
  // public int user_update(int userNo) throws Exception {
  //   int result = adminMapper.user_update(userNo);
  //   return result;
  // }

  // // 사용자 정보 삭제
  // @Override
  // public int user_delete(int userNo) throws Exception {
  //   int result = adminMapper.user_delete(userNo);
  //   return result;
  // }

  // 관리자 정보 등록
  @Override
  public int admin_insert(Admin admin) throws Exception {
      // 비밀번호 암호화
      String adminPw = admin.getAdminPw();
      String encodedPw = passwordEncoder.encode(adminPw);
      admin.setAdminPw(encodedPw);
      String username = admin.getAdminId();

      // 관리자 등록
      int result = adminMapper.admin_insert(admin);

      // 권한 등록
      if( result > 0 ) {
          Auth Auth = new Auth();
          Auth.setUserId( username );
          Auth.setAuth("ROLE_ADMIN");
         // Auth.setIsEnabled(1);           
          result = adminMapper.insertAuth(Auth);
      }
    return result;
  }

  // 항공권 번호로 당일의 탑승객 조회 (확인 필요)
    @Override
  public Users ticket_select(int flightNo) throws Exception {
    Users passenger = adminMapper.ticket_select(flightNo);
    return passenger;
  }

  // 탑승권 목록 내역 조회(전체)
  @Override
  public List<Admin> ticket_list() throws Exception {
    List<Admin> ticketList = adminMapper.ticket_list();
    return ticketList;
  }

  // 탑승 처리 : (탑승완료1, 미탑승0)
  @Override
  public int ticket_used(int ticketNo) throws Exception {
    int result = adminMapper.ticket_used(ticketNo);
    return result;
  }

  // 전체 예매 내역 조회
  @Override
  public List<Admin> booking_list() throws Exception {
    List<Admin> bookingList = adminMapper.booking_list();
    return bookingList;
  }
  @Override
  public List<Admin> admin_list() throws Exception {
    List<Admin> adminList = adminMapper.booking_list();
    return adminList;
  }
  
}