package org.koreait.controllers;

import javax.validation.Valid;

import org.koreait.models.member.MemberJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/join")
public class MemberJoinController {
	
	// 생성자 매개변수로 의존성 주입
	private MemberJoinValidator validator;
	
	public MemberJoinController(MemberJoinValidator validator) {
		this.validator = validator;
	}
	
	@Autowired
	private MemberJoinService service;
	

	@GetMapping
	public String join(Model model) {
		MemberJoin memberJoin = new MemberJoin();
		
		model.addAttribute("memberJoin", memberJoin);
		
		return "member/join";
	}
	
	
	@PostMapping
	public String joinPs(@Valid MemberJoin member, Errors errors) {	// Memberjoin이라는 커맨드객체에 join.jsp의 input value가 set됨.
		validator.validate(member, errors);
		
		if(errors.hasErrors()) {
			return "member/join";
		}
		
		// 회원가입처리
		service.join(member);
		
		return "redirect:/member/login";	// 회원가입 완료 후 로그인 페이지 이동
	}
}
