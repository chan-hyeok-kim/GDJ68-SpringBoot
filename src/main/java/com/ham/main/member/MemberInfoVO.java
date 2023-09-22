package com.ham.main.member;

import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfoVO {
 
	@NotBlank
	private String name;
	
	@Email
	private String email;
	
	@Past
	private Date birth;
	private Date joinDate;
}
