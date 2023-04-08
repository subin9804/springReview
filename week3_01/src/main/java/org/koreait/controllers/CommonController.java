package org.koreait.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("org.koreait.controllers")	// 해당 패키지와 하위 패키지 및 클래스륻에 해당
public class CommonController {
	
	@ExceptionHandler(Exception.class)
	public String errorHandler(Exception e, Model model) {
		model.addAttribute("message", e.getMessage());
		e.printStackTrace();
		return "error/common";
	}
}
