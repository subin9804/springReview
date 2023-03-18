package org.koreait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@GetMapping("/hello")	// @RequestParam: 쿼리스트링의 name이 String nm이라는 것을 알려줌 / required() default true
	public String hello(@RequestParam(name="name", required=false) String nm, Model model) {	
		System.out.println(nm);
		model.addAttribute("name", nm);
		
		return "hello";
	}

	/**
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		mv.addObject("name", "이이름");
		
		return mv;
	}
	*/
}
