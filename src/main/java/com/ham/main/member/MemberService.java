package com.ham.main.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService implements UserDetailsService{

	@Autowired
	private MemberDAO memberDAO;
	
	public void testValid(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception{
		log.info("Test Valid : {}", memberVO);
	}
	
	
	
	//검증 메서드
	public boolean getMemberError(MemberVO memberVO,BindingResult bindingResult) throws Exception {
		boolean check=false; //에러가 없다, true면 에러가 있다(검증 실패)
		
		if(!memberVO.getPassword().equals(memberVO.getPasswordCheck())) {
				check=true;
			    bindingResult.rejectValue("passwordCheck", "memberVO.password.equalCheck");;
//			    reject의 에러코드는 프로퍼티스의 키
//			    검증 어노테이션이 따로 없어서 만들어줘야 함.
		}
		
		//ID 중복 검사
		MemberVO checkVO = memberDAO.getMember(memberVO);
		
		if(checkVO!=null) {
			check=true;
			bindingResult.rejectValue("username", "memberVO.username.equalCheck");
		}
		
		return check;
	}
	
	
    public MemberVO getLogin(MemberVO memberVO) throws Exception{
		MemberVO loginVO =  memberDAO.getMember(memberVO);
		
		if(loginVO==null){
			return loginVO;
		}
		
		if(loginVO.getPassword().equals(memberVO.getPassword())) {
			return loginVO;
		}
		return null;
	}
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	// TODO Auto-generated method stub
    	log.info("===== 로그인 시도 중 ========");
    	MemberVO memberVO = new MemberVO();
    	memberVO.setUsername(username);
    	try {
			memberVO = memberDAO.getMember(memberVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			memberVO=null;
		}
    	return memberVO;
    }
	
	
	
	
	
}
