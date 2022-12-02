package com.post.blog.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//JPA를 통해 DB생성

@Builder
@AllArgsConstructor //모든 생성자
@NoArgsConstructor //기본생성자 생성
@Data  //getter+setter
@Entity //User 클래스가 MySQL 테이블에 생성됨
public class User {

	@Id//pk
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라감
	private int id; //pk
	
	@Column(nullable = false, length = 30, unique = true )
	private String username; //유저 아이디
	 
	@Column(nullable = false, length = 100)
	private String password; //비밀번호
	
	@Column(nullable = false, length = 50)
	private String email; //이메일
	
	@Column(nullable = false, length = 30)
	private String nickname; //이름
	
	@Enumerated(EnumType.STRING)
	private Role role; //역할 (회원/관리자)
	
	@CreationTimestamp//시간 자동입력
	private Timestamp createDate; //회원가입날짜
}
