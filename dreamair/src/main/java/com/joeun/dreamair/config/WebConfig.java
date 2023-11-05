package com.joeun.dreamair.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration          // 빈 등록 설정 클래스 지정
public class WebConfig {

    //application.properties에 설정한 "uploadPath" 프로퍼티 값을 읽어옴
    // @Value("${uploadPath}")
    // String uploadPath;

    // @Bean                   // 빈 등록
    // public PasswordEncoder passwordEncoder() {
    //      return new BCryptPasswordEncoder();
    //     // return NoOpPasswordEncoder.getInstance();
    //     // BCryptPasswordEncoder        : BCrypt 해시 알고리즘을 사용하여 비밀번호 암호화 
    //     // NoOpPasswordEncoder          : 암호화 없이 비밀번호를 저장
    //     // ...
    // }

    @Bean
    public PasswordEncoder passwordEncoder() {
         return new BCryptPasswordEncoder();
//         {
//             @Override
//             public String encode(CharSequence rawPassword) {
//                 if (rawPassword == null || rawPassword.length() == 0) {
//                     throw new IllegalArgumentException("Password cannot be empty.");
//                 }
//                 return super.encode(rawPassword);
//             }
//         };
    
 }
    
}
