package com.post.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//스프링 시큐리티
//auth: 인증이 안된 사용자 출입경로
//static이하에 있는 js,css,image 허용

@Controller
public class UserController {
	
	@GetMapping({"","/"})
	public String main() {
		
		return "main";
	}
	
	//회원가입 페이지 이동 (로그인X)
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		
		return "user/joinForm";
	}
	
	//로그인 페이지 이동
	@GetMapping("/auth/loginForm")
	public String loginForm(@RequestParam(value = "error", required = false) String error
												, @RequestParam(value = "exception", required = false) String exception
												, Model model) {
		
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		
		return "user/loginForm";
	}
	
	//회원정보수정 페이지
		@GetMapping("/user/updateForm")
		public String updateForm() {
			
			return "user/updateForm";
		}
	
	
}
