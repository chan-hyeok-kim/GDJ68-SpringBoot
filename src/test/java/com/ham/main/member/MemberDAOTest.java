package com.ham.main.member;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class MemberDAOTest {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//@Test
	void test() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("admin");
		
		memberVO = memberDAO.getMember(memberVO);
		log.info("Member : {}", memberVO);
		assertNotNull(memberVO);
		
	}
	
	@Test
	void passwordTest() throws Exception {
	     String pass = passwordEncoder.encode("admin");
	     log.info(pass);
	}
}
