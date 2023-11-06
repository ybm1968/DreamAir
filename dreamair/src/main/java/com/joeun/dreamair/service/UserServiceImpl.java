package com.joeun.dreamair.service;

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

import com.joeun.dreamair.dto.Auth;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    
    @Override
    public int insert(Users user) throws Exception {
        // 비밀번호 암호화
        String userPw = user.getUserPw();
        String encodedPw = passwordEncoder.encode(userPw);
        user.setUserPw(encodedPw);

        // 회원 등록
        int result = userMapper.insertUsers(user);

        // auth 테이블에 데이터 추가
        if( result > 0 ) {
            Auth Auth = new Auth();
            Auth.setUserId( user.getUserId() );
            Auth.setAuth("ROLE_USER");          // 기본 권한 : 사용자 권한 (ROLE_USER)
            result = userMapper.insertAuth(Auth);
        }

        // mileage 테이블에 데이터 추가
        if (result > 0) {
            user.setUserId(user.getUserId());
            result = userMapper.insertMileage(user);
        }

        return result;
    }



    @Override
    public Users select(int userNo) throws Exception {
        return userMapper.select(userNo);
    }



    @Override
    public void login(Users user, HttpServletRequest requset) throws Exception {

        String username = user.getUserId();
        String password = user.getUserPwCheck();
        log.info("username : " + username);
        log.info("password : " + password);

        // 아이디, 패스워드 인증 토큰 생성
        UsernamePasswordAuthenticationToken token 
            = new UsernamePasswordAuthenticationToken(username, password);

        // 토큰에 요청정보를 등록
        token.setDetails( new WebAuthenticationDetails(requset) );

        // 토큰을 이용하여 인증(로그인)
        Authentication authentication = authenticationManager.authenticate(token);

        User authUser = (User) authentication.getPrincipal();
        log.info("인증된 사용자 아이디 : " + authUser.getUsername());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }



    @Override
    public Users selectById(String userId) throws Exception {
        Users user = userMapper.selectById(userId);
        return user;
    }


    
    @Override
    public int update(Users user) throws Exception {
        // 비밀번호 암호화
        String userPw = user.getUserPw();
        String encodedPw = passwordEncoder.encode(userPw);
        user.setUserPw(encodedPw);

        int result = userMapper.update(user);

        return result;
    }
    
    
    // 회원 탈퇴
    @Override
    public Users delete(String userId) throws Exception {
        
        // 사용자를 삭제하고 삭제된 사용자 정보를 반환
        Users deleteUser = userMapper.delete(userId);

        return deleteUser;
    }
    

    
    @Override
    public Users selectMileage(String userId) throws Exception {
        
        return userMapper.selectMileage(userId);
        
    }
    
}
