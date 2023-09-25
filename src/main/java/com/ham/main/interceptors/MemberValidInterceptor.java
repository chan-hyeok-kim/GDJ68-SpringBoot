package com.ham.main.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/***
 * Member Update 시
 * Password Vaild 제외하기
 * @author GDJ68
 */
@Component
public class MemberValidInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		/***
		 * request에 setParameter없음
		 * 이외에도 파라미터 세팅 불가능
		 */
		return true;
	}
	
	
}
