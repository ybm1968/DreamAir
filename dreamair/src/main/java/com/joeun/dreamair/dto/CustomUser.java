package com.joeun.dreamair.dto;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter
public class CustomUser implements UserDetails {

    private static final long serialVersionUID = 1L;
   
    @Autowired
    private Member member;     

    public CustomUser(Member member) {
        this.member = member;
    }

    /**
     * 🟢🟡🔴 권한 getter 메소드
     * ✅ UserDetails 를 CustomUser 로 구현하여, 
     *     Spring Security 의 User 대신 사용자 정의 인증 객체(CustomUser)를 사용한다면,
     *     권한은 'ROLE_' 붙여서 사용해야한다.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return member.getAuthList().stream()
                                  .map( (auth) -> new SimpleGrantedAuthority(auth.getAuth()))
                                  .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return member.getUserPw();
    }

    @Override
    public String getUsername() {
        return member.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return member.getEnabled() == 0 ? false : true;
    }

    
}