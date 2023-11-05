package com.joeun.dreamair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Override
    public int insert(Users user) throws Exception {
        // 비밀번호 암호화
        String userPw = user.getUserPw();
        String encodedPw = passwordEncoder.encode(userPw);
        user.setUserPw(encodedPw);

        // 회원 등록
        int result = userMapper.insert(user);

        // 권한 등록
        if( result > 0 ) {
            Auth Auth = new Auth();
            Auth.setUserId( user.getUserId() );
            Auth.setAuth("ROLE_USER");          // 기본 권한 : 사용자 권한 (ROLE_USER)
            result = userMapper.insertAuth(Auth);
        }
        return result;
    }

    @Override
    public Users select(int userNo) throws Exception {
        return userMapper.select(userNo);
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
  
    // 마일리지 등록
    public int mileageInsert(int userNo) throws Exception {
        int result = userMapper.mileageInsert(userNo);
        return result;
    }

    public int latedUserNo() throws Exception {
        int result = userMapper.latedUserNo();
        return result;
    }
    
    // 아이디 중복 검사
	public int idCheck(String userId){
        return userMapper.idCheck(userId);
    }


}
