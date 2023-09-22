package com.ham.main.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
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
	
	
	
	
	
	
}
