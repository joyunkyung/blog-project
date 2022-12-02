package com.post.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.post.blog.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

		//조회수 증가
		@Modifying
		//update BOARD set count = count + 1 where Id=#{Id}
		@Query(value="UPDATE BOARD p SET p.count = p.count + 1 WHERE p.id = :id", nativeQuery=true)
		int updateCount(int id);
}
