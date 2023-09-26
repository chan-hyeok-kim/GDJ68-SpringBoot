package com.ham.main.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ham.main.board.notice.NoticeDAO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestInterceptor implements HandlerInterceptor {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub\
		log.info("====== Pre Controller 진입 전 ====");
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("========== Post Controller 나가기 전 =======");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("========== JSP 렌더링 후 ==============");
		
	}
	
	
}
