package com.post.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.blog.config.auth.PrincipalDetail;
import com.post.blog.dto.CommentRequestDto;
import com.post.blog.dto.ResponseDto;
import com.post.blog.entity.Board;
import com.post.blog.service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;
	
	//글쓰기
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board
											, @AuthenticationPrincipal PrincipalDetail principal){
											//PrincipalDetail: User정보를 넘겨줌
		
		boardService.write(board, principal.getUser());
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
		}
	
	//글 수정하기
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
		boardService.boardUpdate(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
	//글 삭제하기
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id){
		boardService.boardDelete(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	//댓글 작성
	@PostMapping("/api/board/{boardId}/comment")
	public ResponseDto<Integer> commentSave( @RequestBody CommentRequestDto commentDto) {

		boardService.commentWrite(commentDto);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
	}
	
	//댓글 삭제
	@DeleteMapping("/api/board/{boardId}/comment/{commentId}")
	public ResponseDto<Integer> commentDelete(@PathVariable int commentId) {
		
		boardService.commentDelete(commentId);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1); 
		
	}
}
	

