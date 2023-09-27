package com.ham.main.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ham.main.member.MemberService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private SecuritySuccessHandler securitySuccessHandler;
	
	@Autowired
	private MemberService memberService;
	
	

	@Bean
	//API처럼 직접 어노테이션을 줄 수 없는 경우, Bean으로 객체 생성 가능
    //스프링 풀에 객체 등록
	WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web
				.ignoring()
				.antMatchers("/css/**")
				.antMatchers("/js/**")
				.antMatchers("/vendor/**")
				.antMatchers("/img/**")
				; 
//		메서드 체이닝
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		    .cors()
		    .and()
		    .csrf()
		    .disable()
		    .authorizeHttpRequests()
				.antMatchers("/notice/add").hasRole("ADMIN") // ROLE_ADMIN에서 ROLE_제외
				.antMatchers("/manager/*").hasAnyRole("MANAGER", "ADMIN")
		    //.antMatchers("/manager/*")
				.antMatchers("/").permitAll()
				.and()
		    //form 관련 설정
			.formLogin()
			    .loginPage("/member/login")//내장된 로그인폼을 사용하지 않고, 개발r 만든 폼을 사용
//			    POST 로그인을 처리하는 주소
//			    .successHandler(securitySuccessHandler)
			    .defaultSuccessUrl("/")
			    .failureHandler(this.getFailureHandler())
//			    .failureUrl("/member/login?message=LoginFail")
		        .permitAll()
		        .and()
		    .logout()
//		        .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout")) // 도 사용 가능
		        .logoutUrl("/member/logout")
//		        .logoutSuccessUrl("/")
		        .addLogoutHandler(this.getLogoutAdd())
		        .logoutSuccessHandler(this.getLogoutHandler())
		        .invalidateHttpSession(true)
		        .deleteCookies("JSESSIONID")
		        .and()
		    .rememberMe()
		        .tokenValiditySeconds(60)
		        .key("rememberKey")
		        .userDetailsService(memberService)
		        .authenticationSuccessHandler(securitySuccessHandler)
		        .and()
		    .oauth2Login()
		        .userInfoEndpoint()
		        .userService(memberService)
		        .and()
		    
			    ;
		
		return httpSecurity.build();
	}
	
	
	private SecurityFailureHandler getFailureHandler() {
		return new SecurityFailureHandler();
	}
	
	private SecurityLogoutAdd getLogoutAdd() {
		return new SecurityLogoutAdd();
	}
	
	private SecurityLogoutHandler getLogoutHandler() {
		return new SecurityLogoutHandler();
	}
	
	
}
