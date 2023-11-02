package com.joeun.dreamair.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
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

  /**
   * 관리자 로그인
   */
  @Override
  public void admin_login(Admin admin, HttpServletRequest request) throws Exception {
   String adminId = admin.getAdminId();
    String password = admin.getAdminPwCheck();

    log.info("adminId : " + adminId );
    log.info("password : "  + password);

    // 아이디, 패스워드 인증 토큰 생성
    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(adminId, password);

    // 토큰에 요청정보를 등록
    token.setDetails( new WebAuthenticationDetails(request) );
    
    // 토큰을 이용하여 인증(로그인)
    Authentication authentication = authenticationManager.authenticate(token);

    User authUser = (User) authentication.getPrincipal();
    log.info("인증된 사용자 아이디 : " + authUser.getUsername());

    SecurityContextHolder.getContext().setAuthentication(authentication);
  }
  
  @Override
  public int insert(Admin admin) throws Exception {
    // 비밀번호 암호화
    String adminPw = admin.getAdminPw();
    String encodePw = passwordEncoder.encode(adminPw);
    admin.setAdminPw(encodePw);

    // 관리자 등록
    int result = adminMapper.insert(admin);

    // 권한 등록
    if ( result > 0 ){
    Auth adminAuth = new Auth();
    adminAuth.setUserId( admin.getAdminId() );
    adminAuth.setAuth("ROLE_ADMIN");
    result = adminMapper.insertAuth(adminAuth);
}
   return result;
  }
   

  // @Override
  // public Admin login(String adminId) throws Exception {
   
  // }

  /**
   * 사용자 관리
   */
  @Override
  public List<Users> user_list() throws Exception {
    List<Users> userList = adminMapper.user_list();
    return userList;
  }

  @Override
  public int user_insert(int userNo) throws Exception {
    int result = adminMapper.user_insert(userNo);
    return result;
  }

  @Override
  public int user_update(Users user) throws Exception {
    int result = adminMapper.user_update(user);
    return result;
  }

  @Override
  public int user_delete(int userNo) throws Exception {
    int result = adminMapper.user_delete(userNo);
    return result;
  }

}
