package org.koreait.controllers;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MemberLoginValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {	// MemberLogin 커맨드 객체의 값을 검증
		
		return MemberLogin.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberLogin memberLogin = (MemberLogin)target;
		String userId = memberLogin.getUserId();
		String userPw = memberLogin.getUserPw();
		
		/** 필수항목 체크 */
		/**
		if(userId == null || userId.isBlank()) {
			errors.rejectValue("userId", "required");
		}
		
		if(userPw == null || userPw.isBlank()) {
			errors.rejectValue("userPw", "required");
		}
		*/
		
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "required");
		// ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPw", "required");
		
		
		// 스프링이 제공하는 Bean Validation API - 애노테이션에서 다 처리하고 나서 처리를 못하는 부분만 따로 정의
		// ex) 아이디가 존재하는지 -> DB조회 필요
		
	}

}
