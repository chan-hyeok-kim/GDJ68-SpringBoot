package com.ham.main.member;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.Context;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j 
public class MemberController {
 
	@Autowired
	private MemberService memberService;

	@GetMapping("kakaoLogout")
	public String kakaoLogout() {
		log.info("카카오 로그아웃");
		return "redirect:../";
	}
	
	
	@GetMapping("join")
	public void setJoin(@ModelAttribute MemberVO memberVO) throws Exception{
//	     model도 속성명이 없을 경우. 
//	 	 bean처럼 클래스명의 첫글자가 소문자로 된 걸 속성명으로 쓴다 
	}
	
	@PostMapping("join")
	public String setJoin(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile photo) throws Exception{
		/***
		 * @Valid는 컨트롤러에서만 작동 가능
		 */
		
		boolean check = memberService.getMemberError(memberVO, bindingResult);
		
		if(bindingResult.hasErrors() || check) {
			return "member/join";
		}
		
//		회원가입 진행
		int result = memberService.setJoin(memberVO);
		
//		나중에 회원 사진 파일 저장 추가
		
		log.info("Photo : {}---size : {}",photo.getOriginalFilename(),photo.getSize());
		return "redirect:../";
		
	}
	
	@GetMapping("login")
	public String getLogin(@ModelAttribute MemberVO memberVO) throws Exception{
		SecurityContext context = SecurityContextHolder.getContext();
        
		String check = context.getAuthentication().getPrincipal().toString();

		log.info("=========Name:{}=======",context.getAuthentication().getPrincipal().toString());
		
		if(!check.equals("anonymousUser")) {
			return "redirect:/";
		}
		
		return "member/login";
	}

	

	
	@GetMapping("update")
	public void setUpdate(@AuthenticationPrincipal MemberVO memberVO,Model model) throws Exception{
//		MemberVO memberVO = (MemberVO)principal;
//		memberVO = memberService.getLogin(memberVO);
//		
		MemberInfoVO memberInfoVO = new MemberInfoVO();
		memberInfoVO.setName(memberVO.getName());
		memberInfoVO.setBirth(memberVO.getBirth());
		memberInfoVO.setEmail(memberVO.getEmail());
		
		model.addAttribute("memberInfoVO", memberInfoVO);
	}
	
	@PostMapping("update")
	public void setUpdate(@Valid MemberInfoVO memberInfoVO,BindingResult bindingResult) throws Exception{
	    Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    MemberVO memberVO = (MemberVO)object;
	    memberVO.setEmail("updateEmail@naver.com");
	    
	}
	
	@GetMapping("info")
	public void getInfo() throws Exception{
		
		
	   
	}
	
	
	
	
}
