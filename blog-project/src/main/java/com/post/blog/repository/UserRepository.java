package com.post.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.post.blog.entity.User;

//DAO
//자동으로 Bean 등록 //@Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer>{
																						//User 테이블의 PK는 Integer타입
		// SELECT * FROM user WHERE username = 1?;
		//로그인 쿼리
		Optional<User> findByUsername(String username);
		
		//exists: 데이터가 DB에 존재하는지 확인
		//true:데이터 존재,
		//flase: 데이터 존재x
		//아이디 중복확인
		boolean existsByUsername(String username);

}
