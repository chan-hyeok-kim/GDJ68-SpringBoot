package com.ham.main;

import java.security.Principal;
import java.util.Enumeration;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {

	@GetMapping("/")
	public String getIndex(HttpSession session) throws Exception{
		Enumeration<String> en = session.getAttributeNames();

//		Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
	
		
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication auth = context.getAuthentication();
		
//		log.info("=========== GetName: {}=============",auth.getName());
//		log.info("=========== Principal: {}=============",auth.getPrincipal()
//				);
//		log.info("=========== GetAuth: {}=============",auth.getAuthorities());
		
		return "index";
	}
//	SecurityContextImpl -- SecurityContext을 구현한 클래스라는 뜻 

}
