package com.ham.main.config;



import java.io.IOException;
import java.net.HttpURLConnection;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.ham.main.board.PostVO;
import com.ham.main.member.MemberVO;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class SecurityLogoutAdd implements LogoutHandler{
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-secret}")
	private String adminKey;
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		log.info("===========Logout Add==========");
		
		this.userWebClient();
		this.logoutForKakako(authentication);
	    this.logoutKakako(response);
		
		
	}

	private void userRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

		
		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(null,null);
		

		
//		ResponseEntity<PostVO> response = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts/1", PostVO.class, request);
//		PostVO body = response.getBody();
		
//      List<PostVO> body = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts", List.class, request);
		
		ResponseEntity<String> body = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/comments?postId=1", String.class, request);
		log.info("==========JSON: {}=========",body);
		
	}
	
	public void logoutForKakako(Authentication authentication) {
		RestTemplate restTemplate = new RestTemplate();
		
        log.info("*****adminkey:{}*******",adminKey);
		HttpHeaders headers = new HttpHeaders();
		
		MemberVO memberVO = (MemberVO) authentication.getPrincipal();
		String accessToken = memberVO.getAccessToken();
		log.info("***********accessToken: {}*********",accessToken);
		
//		headers.setBearerAuth(accessToken);
		
		headers.add("Authorization", "KakaoAK "+"f21da3ee8866fc9f832018fe54b5b876");
	    headers.add("Content-Type","application/x-www-form-urlencoded"); 
		
	    MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
	    params.add("target_id_type", "user_id");
	    params.add("target_id", memberVO.getName());
	    
	    HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params,headers);
	    
	    ResponseEntity<String> response = restTemplate.postForEntity("https://kapi.kakao.com/v1/user/logout", request, String.class);
	    String body = response.getBody();
	    
	    log.info("************id:{}***********",body);
	}
	
	private void logoutKakako(HttpServletResponse response) {
	    RestTemplate restTemplate = new RestTemplate();
//	    
//	    MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//	    params.add("client_id", "ad31c6a5aaaa8e58d6a71df13e7a8cbd");
//	    params.add("logout_redirect_uri", "/");
//         
	    StringBuffer sb = new StringBuffer();
	    sb.append("https://kauth.kakao.com/oauth/logout?");
	    sb.append("client_id=");
	    sb.append("ad31c6a5aaaa8e58d6a71df13e7a8cbd");
	    sb.append("&logout_redirect_uri=");
	    sb.append("http://localhost:82/member/kakaoLogout");
	    
//	    ResponseEntity<String> response = restTemplate.getForEntity(sb.toString(), String.class);
	    try {
			response.sendRedirect(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	private void userWebClient() {
		WebClient client = WebClient.create();
		
	    Mono<ResponseEntity<PostVO>> res = client.get()
		.uri("https://jsonplaceholder.typicode.com/posts/1")
		.retrieve()
		.toEntity(PostVO.class);
		
		PostVO postVO = res.block().getBody();
		
		log.info("+++++++++++WebClient:{}+++++++", postVO);
		
//		WebClient webClient = WebClient.builder()
//				.baseUrl("https://jsonplaceholder.typicode.com")
//				.build();	
//		Mono<ResponseEntity<PostVO>> res = webClient.get()
//				.uri("posts/1")
//				.retrieve()
//				.toEntity(PostVO.class);
		
		
		
	}
	
}
