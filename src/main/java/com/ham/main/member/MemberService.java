package com.ham.main.member;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberService extends DefaultOAuth2UserService implements UserDetailsService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
    //Social Login
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
	    
		ClientRegistration clientRegistration = userRequest.getClientRegistration();
		OAuth2User auth2User =  super.loadUser(userRequest);
		log.info("=============Auth2user:{}===========",auth2User);
		
		
		String social = clientRegistration.getRegistrationId();
		
		if(social.equals("kakao")) {
			auth2User = this.forKakao(auth2User,userRequest);
		}
		
		return auth2User;
	}
	
	
	private OAuth2User forKakao(OAuth2User auth2User,OAuth2UserRequest userRequest){
		MemberVO memberVO = new MemberVO();
		
		

		LinkedHashMap<String, Object> map = auth2User.getAttribute("properties");
		
		LinkedHashMap<String, Object> accountMap = auth2User.getAttribute("kakao_account");
		
		log.info("****Auth2user properties:{}*********", auth2User.getAttribute("properties").getClass());
		log.info("****{}*********", map);
		auth2User.getAttribute("properties");
		
		LinkedHashMap<String, Object> profile = (LinkedHashMap<String, Object>) accountMap.get("profile");
		
		memberVO.setUsername(map.get("nickname").toString());
		memberVO.setEmail(accountMap.get("email").toString());
	    String birth = accountMap.get("birthday").toString();
	    
        String m = birth.substring(0,2);
        String d = birth.substring(2);

        Calendar calendar = Calendar.getInstance();
        int y = calendar.get(Calendar.YEAR);
	    
	    StringBuffer sb = new StringBuffer();
	    sb.append(y).append("-").append(m).append("-").append(d);
	  
	    //사용자가 DB에 있는지 확인
	    
	    
	    Date day = Date.valueOf(sb.toString());
	    log.info("=========sb:{}======",day);
	    memberVO.setAccessToken(userRequest.getAccessToken().getTokenValue());
	    memberVO.setBirth(day);
	    memberVO.setAttributes(auth2User.getAttributes());
	    memberVO.setName(auth2User.getName());
	    
	    //사용자 권한을 DB에서 조회
	    List<RoleVO> roleList = new ArrayList<>();
	    RoleVO roleVO = new RoleVO();
	    roleVO.setRoleName("ROLE_MEMBER");
	    
	    roleList.add(roleVO);
	    
	    memberVO.setRoleVOs(roleList);
		return memberVO;
	}
	
	
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
	
    //Server Login
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
	
    @Transactional(rollbackFor = Exception.class)
	public int setJoin(MemberVO memberVO) throws Exception{
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		
		int result = memberDAO.setJoin(memberVO);
		
		Map<String, Object> map = new HashMap<>();
		map.put("roleNum",3);
		map.put("username",memberVO.getUsername());
		
		result = memberDAO.setMemberRole(map);
		
		return result;
	}
	
	
	
}
