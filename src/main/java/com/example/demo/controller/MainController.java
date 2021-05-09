package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.LoginService;
import com.example.demo.service.MemberService;

@Controller
public class MainController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/main")
	public String showMain(Principal principal, Model model) {
		
		if(principal != null) {
			model.addAttribute("userId", principal.getName());			
		}
		
		return "main";
	}
	
	@GetMapping("/loginForm")
	public String showLoginForm(String userId, String userPwd) {
		
		System.out.println("form enter");
		System.out.println(userId);
		System.out.println(userPwd);
		return "member/loginForm";
	}
	
	@GetMapping("/enrollForm")
	public String showEnrollForm() {
		
		return "member/enrollForm";
	}
	
	@PostMapping("/enroll")
	public String enroll(Member member) throws Exception {

		memberService.enroll(member);

		return "redirect:main";
	}
	
	@GetMapping("/failure")
	public String showFailurePage(Principal principal, HttpServletRequest request) {
		
		System.out.println("failed");
		
		return "member/failure";
	}
}
