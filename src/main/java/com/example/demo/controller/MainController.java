package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.Member;
import com.example.demo.service.LoginService;

@Controller
public class MainController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/main")
	public String showMain() {
		
		return "main";
	}
	
	@GetMapping("/loginForm")
	public String showLoginForm() {
		
		return "member/loginForm";
	}
	
	@GetMapping("/enrollForm")
	public String showEnrollForm() {
		
		return "member/enrollForm";
	}
	
	@PostMapping("/enroll")
	public String enroll(Member member) throws Exception {

		loginService.enroll(member);

		return "redirect:main";
	}
	
	@GetMapping("/failure")
	public String showFailurePage() {
		
		return "member/failure";
	}
	
	@GetMapping("/success")
	public String showSuccessPage() {
		
		return "member/success";
	}
}
