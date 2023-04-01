package org.koreait.controllers;

import org.koreait.models.member.Member;
import org.koreait.models.member.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.mindrot.jbcrypt.BCrypt;

@Component
public class MemberLoginValidator implements Validator {
	
	@Autowired
	private MemberDao memberDao;
	
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
		
		// 아이디가 존재하는지 -> DB조회 필요
		String msg = "아이디 또는 비밀번호가 일치하지 않습니다";
		
		if(userId != null && !userId.isBlank()) {
			boolean isExist = memberDao.isExists(userId);
			if(!isExist) {	// 아이디가 존재하지 않을 때
				errors.rejectValue("userId", "NotExistxUserId", msg);
			}
		}
		
		
		// 비밀번호 검증
		Member member = memberDao.get(userId);
		System.out.println(member);
		
		String hash = member.getUserPw();
		
		boolean isMatched = BCrypt.checkpw(userPw, hash);
		
		if(!isMatched) {	// 비번이 일치하지 않는 경우
			errors.rejectValue("userPw", "IncorrectUserPw", msg);
		}
	}
	
}


