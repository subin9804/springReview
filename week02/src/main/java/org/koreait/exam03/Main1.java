package org.koreait.exam03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Member member = new Member("user01" ,"123456", "사용자01");
		
		MemberJoinService joinService = ctx.getBean(MemberJoinService.class);
		joinService.join(member);
		
		MemberListService listService = ctx.getBean(MemberListService.class);
		listService.print();
		
		
		ctx.close();

		
	}
}
