package com.ham.main.member;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDAO {

	public MemberVO getMember(MemberVO memberVO) throws Exception;

	public int setJoin(MemberVO memberVO) throws Exception;

	public int setMemberRole(Map<String, Object> map) throws Exception;
}
