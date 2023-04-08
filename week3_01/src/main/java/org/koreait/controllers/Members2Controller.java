package org.koreait.controllers;

import java.util.List;

import javax.validation.Valid;

import org.koreait.models.member.Member;
import org.koreait.models.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Members2Controller {
	
	@Autowired
	private MemberDao memberDao;
	
	
	
	@GetMapping("/members2")
	public String members(@Valid MemberSearch memberSearch, Errors errors, Model model) {
		List<Member>members = memberDao.gets(memberSearch);
		model.addAttribute("members", members);
		
		return "member/members2";
	}
	
	@GetMapping("/member2/{id}")
	public String member(@PathVariable(name="id", required=false) String userId, Model model) {
		
		Member member = memberDao.get(userId);
		model.addAttribute("member", member);
		
		boolean result = false;
		if(!result) {
			throw new RuntimeException("예외 발생!!");
		}
		
		return "member/info2";
	}
	

}
