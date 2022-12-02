package com.post.blog.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity //Board 클래스가 MySQL 테이블에 생성됨
public class Board {
	@Id //PK
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title; //게시글 제목
	
	@Lob //대용량 데이터
	private String content; //게시글 내용
	
	private int count; //조회수
	
	@CreationTimestamp //시간 자동입력
	private Timestamp createDate; //작성날짜
	
	
	//EAGER:즉시로딩
	@ManyToOne(fetch = FetchType.EAGER) //Many=Board, User=One 
	//한명의 유저는 여러개의 게시글 작성가능
	@JoinColumn(name = "userId") //조인
	private User user;
	//private int userId;
	//DB는 오브젝트 생성x, FK,자바는 오브젝트 생성 가능
	
																							//, cascade = CascadeType.REMOVE: 게시글을 삭제하면 댓글도 다 삭제됨
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE) //mappedBy 연관 관계 주인x(PK x) DB에 컬럼생성x
	//하나의 게시글은 여러개의 댓글 가질수 있다
	//@JoinColumn(name = "commentId") 필요없음 
	@JsonIgnoreProperties({"board"}) //comment를 호출할때 board는 빼고 호출해서 무한루프를 막음
	@OrderBy("id desc") //내림차순 정렬(최근댓글이 위로오게)
	private List<Comment> comments;
	
}
