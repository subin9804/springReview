package org.koreait.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	
	// Autowired를 사용하지 않고 의존성 주입
	private MemberLoginValidator validator;
	private MemberLoginService service;
	
	public MemberLoginController(MemberLoginValidator validator, MemberLoginService service) {
		this.validator = validator;
		this.service = service;
	}
	
	

	@GetMapping
	public String login(Model model, @CookieValue(name="saveId", required=false) String sId) {
		MemberLogin memberLogin = new MemberLogin();
		if(sId != null) {
			memberLogin.setSaveId(true);	// 체크
			memberLogin.setUserId(sId);	//값
		}
		
		model.addAttribute(memberLogin);

		return "member/login";
	}
	
	
	@PostMapping
	public String loginPs(@Valid MemberLogin memberLogin, Errors errors) {	// EL식 : MemberLogin -> memberLogin
		validator.validate(memberLogin, errors);
		
		if(errors.hasErrors()) {
			return "member/login";
		}
		
		// 로그인 처리
		service.login(memberLogin);
		 
		return "redirect:/";	// HttpServletResponse sendRedirect와 동일한 기능
	}
}
