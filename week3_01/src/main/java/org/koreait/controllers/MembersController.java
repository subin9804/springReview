package org.koreait.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.koreait.models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MembersController {
	
	@GetMapping("/members/{id}")
	public String info(@PathVariable(required=false, name="id") String userid) {
		System.out.println(userid);
		
		return "member/info";
	}

	@GetMapping("/members")
	public String members(Model model) {
		
		List<Member> members = new ArrayList<>();
		
		for (int i = 1; i <= 10; i++) {
			Member member = new Member();
			member.setUserId("user" + i);
			member.setUserNm("사용자" + i);
			member.setEmail("user" + i + "@test.org");
			member.setMobile("01000000000" + i);
			member.setRegDt(LocalDateTime.now());
			
			members.add(member);
		}
		
		model.addAttribute("members", members);
		
		return "member/members";
	}
}
