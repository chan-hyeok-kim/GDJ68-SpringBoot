package com.ham.main.config;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

import javax.security.auth.login.AccountLockedException;
import javax.security.auth.login.CredentialExpiredException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SecurityFailureHandler implements AuthenticationFailureHandler{

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("===== Exception:{}=======", exception);
//		log.info("===== Local Message:{}=======", exception.getLocalizedMessage());
//		log.info("===== Message:{}=======", exception.getMessage());
		
		String message= "로그인 실패";
		
		if(exception instanceof InternalAuthenticationServiceException) {
			message= "존재하지 않는 아이디입니다";
		}
		
		if(exception instanceof BadCredentialsException) {
			message="비밀번호 불일치";
		}
		
		if(exception instanceof AccountExpiredException) {
			message="계정 유효 기간 만료. 관리자에게 문의";
		}
		
		if(exception instanceof LockedException) {
			message="계정 잠김. 관리자에게 문의";
		}
			
		if(exception instanceof DisabledException) {
			message="휴면 계정입니다.";
		}
		
		if(exception instanceof CredentialsExpiredException) {
			message="발급된 비밀번호의 시간이 만료";
		}
		
		if(exception instanceof AuthenticationCredentialsNotFoundException) {
			message="인증 실패";
		}
		
		message = URLEncoder.encode(message,"UTF-8");
		
		response.sendRedirect("/member/login?message="+message);
	}

	
}
