package org.koreait.exam01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberJoinService joinService = ctx.getBean("memberJoinService", MemberJoinService.class);	// getBean.(빈객체 이름, 클래스 이름);
		
		Member member = new Member("User01", "123456", "사용자01");
		joinService.join(member);
		
		
		MemberListService listService = ctx.getBean(MemberListService.class);
		listService.print();
		
		
		
		
		
		ctx.close();
	}
}
