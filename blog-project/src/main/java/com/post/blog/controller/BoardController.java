package com.post.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.post.blog.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	//글쓰기
	@GetMapping("/board/saveForm")
	public String saveForm() {
		
		return "board/saveForm";
	}
	
	//글목록, 페이징
	@GetMapping("/board/listForm")
	public String listForm(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
															//한페이지당 5건의 데이터 리턴(페이징), 최신순으로
		
		model.addAttribute("boards", boardService.boardList(pageable));
		
		return "board/listForm";
	}
	
	//글 내용보기, 조회수
	@GetMapping("/board/{id}")//{id}: @PathVariable로 처리
	public String detail(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.boardDetail(id));
		boardService.updateCount(id); //조회수
		return "board/detail";
	}
	
	//글 수정하기
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model) {
		model.addAttribute("board", boardService.boardDetail(id));
		return "board/updateForm";
	}
	

	
	
}
