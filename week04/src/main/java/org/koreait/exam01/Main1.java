package org.koreait.exam01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		MemberDao memberDao = ctx.getBean(MemberDao.class);
		
		Member member = new Member();
		member.setUserId("user02");
		member.setUserNm("사용자02");
		member.setUserPw("123456");
		member.setEmail("user02@test.org");
		member.setMobile("01000000000");
		
		boolean result = memberDao.insert(member);
		System.out.println(result);
		
		ctx.close();
	}
}
