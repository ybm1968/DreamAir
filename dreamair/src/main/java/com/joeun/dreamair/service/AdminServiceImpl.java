package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.Auth;
import com.joeun.dreamair.dto.Booking;
import com.joeun.dreamair.dto.Product;
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

  // 전체 관리자 조회
  @Override
  public List<Admin> admin_list() throws Exception {
    List<Admin> adminList = adminMapper.admin_list();
    return adminList;
  }

  // 관리자 등록
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
  
  // 전체 사용자 조회
  @Override
  public List<Users> user_list() throws Exception {
    List<Users> userList = adminMapper.user_list();
     return userList;
  }

  // 관리자 정보 삭제
  @Override
  public int admin_delete(int adminNo) throws Exception {
    int result = adminMapper.admin_delete(adminNo);
    log.info("관리자 삭제 : " + result);

    Admin admin = new Admin();
    admin.setAdminNo(adminNo);
    String userId = admin.getAdminId();

    // 관리자 권한도 삭제
    if( result > 0 ) {
        Auth Auth = new Auth();
        Auth.setUserId( userId );
        // Auth.setAuth("ROLE_ADMIN");
        result = adminMapper.deleteAuth(Auth);
    }
    return result;
  }

  // 사용자 수동 등록
  @Override
  public int user_insert(Users users) throws Exception {
    int result = adminMapper.user_insert(users);
    return result;
  }

  // 사용자 정보 수정
  @Override
  public int user_update(int userNo) throws Exception {
    int result = adminMapper.user_update(userNo);
    return result;
  }

  // 사용자 정보 삭제
  @Override
  public int user_delete(int userNo) throws Exception {
    int result = adminMapper.user_delete(userNo);
    return result;
  }

  
  // 전체 예매 내역 조회
  @Override
  public List<Booking> booking_list() throws Exception {
    List<Booking> bookingList = adminMapper.booking_list();
    return bookingList;
  }

  // 항공권 번호로 당일의 탑승객 조회
    @Override
  public List<Booking> ticket_selectList(String departureDate, int flightNo, int checkedIn, int isBoarded) throws Exception {
    List<Booking> ticketList = adminMapper.ticket_selectList(departureDate, flightNo, checkedIn, isBoarded);

    return ticketList;
  }

  // 탑승권 목록 내역 조회(전체)
  @Override
  public List<Booking> ticket_list(String today) throws Exception {
    List<Booking> ticketList = adminMapper.ticket_list(today);
    return ticketList;
  }

  // 탑승 처리 : (탑승완료1, 미탑승0)
  @Override
  public int ticket_update(int ticketNo) throws Exception {
    int result = adminMapper.ticket_update(ticketNo);
    return result;
  }
  
  // 탑승권 조회 - ticketNo
  @Override
  public List<Booking> pas_ticketList(int ticketNo) throws Exception {
    List<Booking> pasTicketList = adminMapper.pas_ticketList(ticketNo);
    return pasTicketList;
  }

  // 전체 탑승권 조회
  @Override
  public List<Product> product_flightList() throws Exception {
    List<Product> productFlightList = adminMapper.product_flightList();
    return productFlightList;
  }
}
