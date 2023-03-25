package org.koreait.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	
	// Autowired를 사용하지 않고 의존성 주입
	private MemberLoginValidator validator;
	
	public MemberLoginController(MemberLoginValidator validator) {
		this.validator = validator;
	}
	
	

	@GetMapping
	public String login(Model model) {
		
		MemberLogin memberLogin = new MemberLogin();
		model.addAttribute(memberLogin);
		
		return "member/login";
	}
	
	
	@PostMapping
	public String loginPs(@Valid MemberLogin memberLogin, Errors errors) {	// EL식 : MemberLogin -> memberLogin
		validator.validate(memberLogin, errors);
		
		if(errors.hasErrors()) {
			return "member/login";
		}
		 
		return "redirect:/";	// HttpServletResponse sendRedirect와 동일한 기능
	}
}
