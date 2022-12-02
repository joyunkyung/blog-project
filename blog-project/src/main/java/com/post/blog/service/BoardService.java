package com.post.blog.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.post.blog.dto.CommentRequestDto;
import com.post.blog.entity.Board;
import com.post.blog.entity.User;
import com.post.blog.repository.BoardRepository;
import com.post.blog.repository.CommentRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	//글쓰기
	@Transactional
	public void write(Board board, User user) {
		board.setCount(0); //조회수 0
		board.setUser(user);//user정보 
		boardRepository.save(board);
	}
	
	//글목록
	public Page<Board> boardList(Pageable pageable) {
		//페이징할때는 return타입을 List가 아닌 Page로 바꿔줘야함
		
		return boardRepository.findAll(pageable);
	}
	
	//글 내용 보기
	@Transactional(readOnly = true) 
	//readOnly = true: mysql은 select에서만 사용가능 (id부여x)
	//필수는 아니고 성능향상을 위해 씀
	public Board boardDetail(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
				});//영속화
	}
	
	//조회수 증가
	@Transactional
	public int updateCount(int id) {
			return boardRepository.updateCount(id);
	}
	
	//글 수정하기
	@Transactional
	public void boardUpdate(int id, Board requestBoard) {
		Board board = boardRepository.findById(id) 
				.orElseThrow(()->{
					return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");
				}); //영속화
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent());
		// 해당 함수로 종료시(Service가 종료될 때) 트랜잭션이 종료됩니다. 이때 더티체킹 - 자동 업데이트가 됨. db flush ->commit
		//원래 Controller에서 종료 되는데 Service에서 종료시키면 일도 줄어들고 빨리 끝남
	}

	//글 삭제하기
	@Transactional
	public void  boardDelete(int id) {
		boardRepository.deleteById(id);
	}
	
	//댓글 작성
	@Transactional
	public void commentWrite(CommentRequestDto commentDto) {

		int result = commentRepository.mSave(commentDto.getUserId(), commentDto.getBoardId(), commentDto.getContent());
	}
	
	//댓글 삭제
	@Transactional
	public void commentDelete(int commentId) {
		commentRepository.deleteById(commentId);
	}
}
