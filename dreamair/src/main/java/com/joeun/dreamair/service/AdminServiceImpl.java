package com.joeun.dreamair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.Product;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.mapper.AdminMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AdminServiceImpl implements AdminService {
    
  @Autowired
  private AdminMapper adminMapper;

  // @Autowired
  // private PasswordEncoder passwordEncoder;

  // @Autowired
  // private AuthenticationManager authenticationManager;

  // 관리자 로그인 조회
  @Override
  public Admin admin_login(@RequestParam String adminId, @RequestParam String adminPw) throws Exception {
    Admin admin = adminMapper.admin_login(adminId, adminPw); 
    return admin;
  }

  /**
   * 관리자 로그인
   */
  // @Override
  // public void admin_login(Admin admin, HttpServletRequest request) throws Exception {
  //  String adminId = admin.getAdminId();
  //   String password = admin.getAdminPwCheck();

  //   log.info("adminId : " + adminId );
  //   log.info("password : "  + password);

  //   // 아이디, 패스워드 인증 토큰 생성
  //   UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(adminId, password);

  //   // 토큰에 요청정보를 등록
  //   token.setDetails( new WebAuthenticationDetails(request) );
    
  //   // 토큰을 이용하여 인증(로그인)
  //   Authentication authentication = authenticationManager.authenticate(token);

  //   User authUser = (User) authentication.getPrincipal();
  //   log.info("인증된 사용자 아이디 : " + authUser.getUsername());

  //   SecurityContextHolder.getContext().setAuthentication(authentication);
  // }
  
//   @Override
//   public int admin_insert(Admin admin) throws Exception {
//     // 비밀번호 암호화
//     String adminPw = admin.getAdminPw();
//     String encodePw = passwordEncoder.encode(adminPw);
//     admin.setAdminPw(encodePw);

//     // 관리자 등록
//     int result = adminMapper.admin_insert(admin);

//     // 권한 등록
//     if ( result > 0 ){
//       Auth adminAuth = new Auth();
//       adminAuth.setUserId( admin.getAdminId() );
//       adminAuth.setAuth("ROLE_ADMIN");
//       result = adminMapper.insertAuth(adminAuth);
// }
//    return result;
//   }


  // 사용자 전체 조회
  @Override
  public List<Users> user_list() throws Exception {
    List<Users> userList = adminMapper.user_list();
    return userList;
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

  // 관리자 정보 등록
  @Override
  public int admin_insert(Admin admin) throws Exception {
    int result = adminMapper.admin_insert(admin);
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
  
}
