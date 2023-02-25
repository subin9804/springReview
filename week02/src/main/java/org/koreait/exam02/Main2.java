package org.koreait.exam02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Member member = new Member("user01", "123456", "사용자01");
		
		MemberJoinService joinService = ctx.getBean("memberJoinService", MemberJoinService.class);
		joinService.join(member);
		
		MemberListService listService = ctx.getBean("memberListService", MemberListService.class);
		listService.print();
		
		
		ctx.close();
	}
}
