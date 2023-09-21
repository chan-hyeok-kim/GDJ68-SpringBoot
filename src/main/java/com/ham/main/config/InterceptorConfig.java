package com.ham.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import com.ham.main.interceptors.TestInterceptor;

// spring부트 시작시에 먼저 읽어라
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private TestInterceptor testInterceptor;
	
	@Autowired
	private LocaleChangeInterceptor localeChangeInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(testInterceptor)
		        .addPathPatterns("/notice/list")
		        ;
		
		registry.addInterceptor(localeChangeInterceptor)
		        .addPathPatterns("/**")
		        ;
		
	}
	
	
	
	
}
