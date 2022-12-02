package com.post.blog.dto;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.post.blog.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
	
	private int id;
	
	@NotBlank(message = "(필수) 아이디를 입력해주세요.")
	//@Size(min=4, message = "아이디는 4글자 이상이어야 합니다.")
	private String username;
	
	@NotBlank(message = "(필수) 비밀번호를 입력해주세요.")
	@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
	private String password;
	
	@NotBlank(message = "(필수) 이름을입력해주세요.")
	private String nickname;
	
	@NotBlank(message = "(필수) 이메일을 입력해주세요.")
	//@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식이 올바르지 않습니다.")
	@Email(message = "이메일 형식이 올바르지 않습니다.")
	private String email;
	
	
	private Role role; 
	
	private Timestamp createDate;
	
	
}
