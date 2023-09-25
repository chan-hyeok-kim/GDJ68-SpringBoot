package com.ham.main.config;

import java.util.Locale;

import javax.servlet.http.Cookie;
import javax.websocket.Session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageConfig implements WebMvcConfigurer{
	
		@Bean
		public LocaleResolver localeResolver() {
			//1. session
			SessionLocaleResolver resolver = new SessionLocaleResolver();
			resolver.setDefaultLocale(Locale.KOREAN);
		    
			//2. cookie
			CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
			cookieLocaleResolver.setDefaultLocale(Locale.KOREAN);
			cookieLocaleResolver.setCookieName("lang");
			
			return cookieLocaleResolver;
		}
		
		// Message Interceptor 객체 생성
		@Bean
		public LocaleChangeInterceptor changeInterceptor() {
			LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
			
			interceptor.setParamName("lang");
//			파라미터를 받아서 언어 구분
//			url?lang=en
			return interceptor;
		}
		
	
}
