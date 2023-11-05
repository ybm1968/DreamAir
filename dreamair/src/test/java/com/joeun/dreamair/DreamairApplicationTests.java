package com.joeun.dreamair;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joeun.dreamair.dto.Admin;
import com.joeun.dreamair.mapper.AdminMapper;
import com.joeun.dreamair.mapper.UserMapper;

@SpringBootTest
class DreamairApplicationTests {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AdminMapper adminMapper;
	@Test
	void contextLoads() {
		
	}

	// 아이디 중복검사
	// @Test
	// public void userIdChk() throws Exception{
	// 	String id = "admin";	// 존재하는 아이디
	// 	String id2 = "1test123";	// 존재하지 않는 아이디
	// 	userMapper.idCheck(id);
	// 	userMapper.idCheck(id2);
	// }

	/* 로그인 쿼리 mapper 메서드 테스트 */
    // @Test
    // public void admin_Login() throws Exception{
      

    //     Admin admin = new Admin();
        /* 올바른 아이디 비번 입력경우 */
        // admin.setAdminId("admin");
        // admin.setAdminPw("123456");
        
        /* 올바른 않은 아이디 비번 입력경우 */
        // admin.setAdminId("test1123");
        // admin.setAdminPw("test1321321");
        // String username = admin.getAdminId();
       	// admin =  adminMapper.admin_login(username);
        // System.out.println("결과 값 : " + admin);
        
    // }
 

}
