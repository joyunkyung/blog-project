package com.post.blog.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.post.blog.dto.UserRequestDto;
import com.post.blog.entity.Role;
import com.post.blog.entity.User;
import com.post.blog.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder; //패스워드 해쉬 암호화
	
	//회원가입
	@Transactional //트랜젝션: 전체성공(commit), 전체실패(rollback)
	public void join(UserRequestDto userDto) {
//		String rawPassword = user.getPassword(); //원래 내가 입력한 비번
//		String encpassword = encoder.encode(rawPassword); //해쉬화된 비번
//		user.setPassword(encpassword);
//		user.setRole(RoleType.USER);
//		userRepository.save(user);
		
		User user = User.builder()
							.username(userDto.getUsername())
							.password(encoder.encode(userDto.getPassword()))
							.nickname(userDto.getNickname())
							.email(userDto.getEmail())
							.role(Role.USER)
							.build();
		
		userRepository.save(user);
	}
	
	//회원가입시 유효성 체크
	@Transactional(readOnly = true)
	public Map<String, String> validateHandling(BindingResult bindingResult) {
					//validateHandling: Controller에서 발생한 에러를 전달받아 정재한 뒤 다시 반환해주는 함수
					//반환된 Data는 user.js에서 사용
		Map<String, String> validatorResult = new HashMap<>();
		

		for(FieldError error : bindingResult.getFieldErrors()) {
			String validKeyName = String.format("valid_%s", error.getField());
			validatorResult.put(validKeyName, error.getDefaultMessage());
		}
		//Key : valid_{dto 필드명}
		//Message : dto에서 작성한 message 값
		
		return validatorResult;
	}
	
	//회원정보수정
	@Transactional
	public void updateUser(UserRequestDto userDto) {
// 수정시에는 영속성 컨텍스트 User 오브젝트를 영속화시키고, 영속화된 User 오브젝트를 수정
// select를 해서 User오브젝트를 DB로 부터 가져오는 이유는 영속화를 하기 위해서!!
// 영속화된 오브젝트를 변경하면 자동으로 DB에 update문을 날려줌
//persistance: 영속성
		User persistance = userRepository.findById(userDto.getId())
				.orElseThrow(()->{
					return new IllegalArgumentException("회원 찾기 실패");
				});
		String rawPassword = userDto.getPassword();
		String encPassword = encoder.encode(rawPassword);
		persistance.setPassword(encPassword);
		persistance.setNickname(userDto.getNickname());
		persistance.setEmail(userDto.getEmail());
	// 회원수정 함수 종료시 = 서비스 종료 = 트랜잭션 종료 = commit 이 자동으로 됨
	// 영속화된 persistance 객체의 변화가 감지되면 더티체킹이 되어 update문을 날려줌
	}
	
	

}
