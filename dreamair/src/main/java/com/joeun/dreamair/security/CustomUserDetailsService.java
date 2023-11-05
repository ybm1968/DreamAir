package com.joeun.dreamair.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.dto.CustomUser;
import com.joeun.dreamair.dto.Member;
import com.joeun.dreamair.dto.Users;
import com.joeun.dreamair.mapper.AdminMapper;
import com.joeun.dreamair.mapper.MemberMapper;
import com.joeun.dreamair.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * UserDetailsService 
 * : Spring Security에서 사용자 정보를 데이터베이스에서 가져와서,
 *   사용자 인증을 수행하기 위한 인터페이스
 * * 위 인터페이스를 구현하여 loadUserByUsername() 재정의하면,
 * * 데이터베이스나 다른 소스로부터 사용자 인증정보를 가져와서 스프링 시큐리티에 전달해줄 수 있다.
 */
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private MemberMapper memberMapper;


    /**
     *  사용자 정의 사용자 인증 메소드
     *  UserDetails
     *    ➡ Users
     *        ⬆ CustomUser   
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("userId : " + username);

        //Users user = userMapper.login(username);
        Member member = memberMapper.login(username);
        Member member2 = memberMapper.login2(username);
        Member member3 = memberMapper.admin_login(username);

        if (member==null&&member2==null&&member3==null) {
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
        }
        
        if(member!=null){
            member = memberMapper.login(username);
        } else if(member2!=null){
            member = member2;
        } else member = member3;

        log.warn("username : " + username);

        // 🟢🟡🔴 CustomUser (➡User) 사용
        CustomUser customUser = new CustomUser(member);
        return customUser;
        

    }
}