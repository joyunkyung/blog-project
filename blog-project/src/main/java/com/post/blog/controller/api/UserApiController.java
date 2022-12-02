package com.post.blog.controller.api;

import java.util.Map;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.blog.dto.ResponseDto;
import com.post.blog.dto.UserRequestDto;
import com.post.blog.entity.User;
import com.post.blog.service.UserService;
import com.post.blog.validator.CheckUsernameValidator;

import lombok.RequiredArgsConstructor;

//스프링 시큐리티
//auth: 인증이 안된 사용자 출입경로
//static이하에 있는 js,css,image 허용

@RestController
@RequiredArgsConstructor //초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
public class UserApiController {
	@Autowired
	private UserService userService;
	
	@Autowired 
	//회원정보수정시 세션등록
	private AuthenticationManager authenticationManager;

	//중복체크 유효성검사
	private final CheckUsernameValidator checkUsernameValidator;
	
	//커스텀 유효성 검증
	@InitBinder //특정 컨트롤러에서 바인딩 또는 검증 설정을 변경하고 싶을 때 사용
	public void validatorBinder(WebDataBinder binder) {
		//WebDataBinder: HTTP 요청 정보를 컨트롤러 메소드의 파라미터나 모델에 바인딩할 때 사용되는 바인딩 객체
		binder.addValidators(checkUsernameValidator);
	}
	
	//회원가입
	@PostMapping("/auth/joinProc")
	public ResponseDto<?> save(@Valid @RequestBody UserRequestDto userDto, BindingResult bindingResult) {
																																		//BindingResult:검증 오류가 발생할 경우 오류 내용을 보관하는 스프링 프레임워크에서 제공
		//검증
		if(bindingResult.hasErrors()) {
			Map<String, String> validatorResult = userService.validateHandling(bindingResult);
			
			return new ResponseDto<>(HttpStatus.BAD_REQUEST.value(), validatorResult);
		}
		
		userService.join(userDto);
		
//		return new ResponseDto<Integer>(200, 1); //200: 통신 정상
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //200이라고 적는 것 보다 이게 더 안정적 
	}

	
	//회원정보수정
	@PutMapping("/user")
	public ResponseDto<?> update(@RequestBody UserRequestDto userDto) {
		userService.updateUser(userDto);
		
		//세션값 변경하기
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); //200이라고 적는 것 보다 이게 더 안정적 
	}
	
	}
	


