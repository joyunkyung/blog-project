package com.post.blog.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //Comment 클래스가 MySQL 테이블에 생성됨
public class Comment {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 200)
	private String content; //댓글내용
	
	@ManyToOne
	//하나의 게시글에 여러개의 댓글
	@JoinColumn(name="boardId")
	private Board board;
	
	@ManyToOne 
	//한명의 유저는 여러개의 답변 작성가능
	@JoinColumn(name = "userId") //조인
	private User user;
	
	@CreationTimestamp //시간 자동입력
	private Timestamp createDate; //댓글작성시간
}
