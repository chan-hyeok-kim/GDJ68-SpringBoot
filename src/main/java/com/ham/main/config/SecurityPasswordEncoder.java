package com.ham.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityPasswordEncoder {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
//		암호화시켜주는 패스워드인코더
	}
	
}
