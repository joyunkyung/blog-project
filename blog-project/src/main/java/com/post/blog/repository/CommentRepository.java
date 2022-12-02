package com.post.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.post.blog.entity.Board;
import com.post.blog.entity.Comment;

public interface CommentRepository  extends JpaRepository<Comment, Integer>{

	//댓글작성
	@Modifying //insert, update, delete시 사용
	@Query(value="INSERT INTO comment(userId, boardId, content, createDate) VALUES(?1, ?2, ?3, now())", nativeQuery = true)
	int mSave(int userId, int boardId, String content); // 업데이트된 행의 개수를 리턴해줌.  
}
