package com.post.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.post.blog.config.auth.PrincipalDetail;

@Controller
public class AdminComtroller {

	@GetMapping("/board/{id}/admin")
		public String adminForm(@PathVariable int id, Model model, @AuthenticationPrincipal PrincipalDetail principal) {
		
		
		return "board/admin";
	}
}
