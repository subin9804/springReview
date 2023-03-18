package org.koreait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberJoinController {

	@GetMapping("/join")
	public String join(Model model) {
		MemberJoin memberJoin = new MemberJoin();
		
		memberJoin.setUserId("<h1>user01</h1>");
		memberJoin.setUserPw("123456");
		memberJoin.setUserNm("사용자01");
		
		model.addAttribute("memberJoin", memberJoin);
		
		return "member/join";
	}
	
	
	@PostMapping("/join")
	public String joinPs(MemberJoin member) {	// Memberjoin이라는 커맨드객체에 join.jsp의 input value가 set됨.
		System.out.println(member);
		
		return "member/join";
	}
}
