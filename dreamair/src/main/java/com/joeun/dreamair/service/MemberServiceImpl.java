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

import com.joeun.dreamair.dto.Member;
import com.joeun.dreamair.mapper.MemberMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationManager authenticationManager;

    // 로그인
    @Override
    public void login(Member member, HttpServletRequest requset) throws Exception{
        String username = member.getUserId();
        String password = member.getUserPwCheck();
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
    public void login2(Member member, HttpServletRequest requset) throws Exception{
        String username = member.getUserId();
        String password = member.getUserPwCheck();
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
    public void admin_login(Member member, HttpServletRequest request) throws Exception{
        String username = member.getAdminId();
        String password = member.getAdminPwCheck();
        log.info("username : " + username);
        log.info("password : " + password);

        // 아이디, 패스워드 인증 토큰 생성
        UsernamePasswordAuthenticationToken token 
            = new UsernamePasswordAuthenticationToken(username, password);

        // 토큰에 요청정보를 등록
        token.setDetails( new WebAuthenticationDetails(request) );

        // 토큰을 이용하여 인증(로그인)
        Authentication authentication = authenticationManager.authenticate(token);

        User authUser = (User) authentication.getPrincipal();
        log.info("인증된 사용자 아이디 : " + authUser.getUsername());

        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    // 사용자 조회
    @Override
    public List<Member> user_list() throws Exception {
        return memberMapper.user_list();
    }
    
}
