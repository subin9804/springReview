package org.koreait.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.koreait.models.member.Member;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MemberOnlyInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		if(member != null) {	// 회원 접속인 경우
			return true;
		}
		
		// 비회원 접속 -> 로그인페이지 이동
		String url = request.getContextPath() + "/member/login";
		response.sendRedirect(url);
		
		
		return false;
	}
	
	
}
