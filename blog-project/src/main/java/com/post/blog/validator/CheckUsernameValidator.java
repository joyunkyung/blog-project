package com.post.blog.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.post.blog.dto.UserRequestDto;
import com.post.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;
//중복검사 클래스

@RequiredArgsConstructor //초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성
@Component //doValidate를 구현해 검증로직을 작성하고 bean으로 등록될 수 있도록 @Component 어노테이션을 사용
public class CheckUsernameValidator extends AbstractValidator<UserRequestDto> {

	private final UserRepository userRepository;

	@Override
	protected void doValidate(UserRequestDto dto, Errors errors) {
		if(userRepository.existsByUsername(dto.getUsername())) {
			errors.rejectValue("username", "아이디 중복 오류", "이미 사용중인 아이디 입니다");
		}
	}
}
