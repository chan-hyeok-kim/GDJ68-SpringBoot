package com.ham.main.member;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j 
public class MemberController {
 
	@Autowired
	private MemberService memberService;

	@GetMapping("join")
	public void setJoin(@ModelAttribute MemberVO memberVO) throws Exception{
//	     model도 속성명이 없을 경우. 
//	 	 bean처럼 클래스명의 첫글자가 소문자로 된 걸 속성명으로 쓴다 
	}
	
	@PostMapping("join")
	public String setJoin(@Valid MemberVO memberVO, BindingResult bindingResult, MultipartFile photo) throws Exception{
		
		log.info("====={}",memberVO);
		boolean check = memberService.getMemberError(memberVO, bindingResult);
		
		if(bindingResult.hasErrors() || check) {
			return "member/join";
		}
		
//		회원가입 진행
		
		
		log.info("Photo : {}---size : {}",photo.getOriginalFilename(),photo.getSize());
		return "redirect:../";
		
	}
	
	@GetMapping("login")
	public void getLogin(@ModelAttribute MemberVO memberVO) throws Exception{
		
	}
	
	@PostMapping("login")
    public String getLogin(MemberVO memberVO,HttpSession session) throws Exception{
		memberVO = memberService.getLogin(memberVO);
		if(memberVO!=null) {
			session.setAttribute("member", memberVO);
			return "redirect:../";
		}
		
		return "redirect:./login";
	}
	
	@GetMapping("logout")
	public String getLogOut(HttpSession session) throws Exception{
		
		session.invalidate();
		
		return "redirect:../";
	}
	
	@GetMapping("update")
	public void setUpdate(HttpSession session,Model model) throws Exception{
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		memberVO = memberService.getLogin(memberVO);
		
		MemberInfoVO memberInfoVO = new MemberInfoVO();
		memberInfoVO.setName(memberVO.getName());
		memberInfoVO.setBirth(memberVO.getBirth());
		memberInfoVO.setEmail(memberVO.getEmail());
		
		model.addAttribute("memberInfoVO", memberInfoVO);
	}
	
	@PostMapping("update")
	public void setUpdate(@Valid MemberInfoVO memberInfoVO,BindingResult bindingResult) throws Exception{
	   	
	   
	}
	
	
	
}
