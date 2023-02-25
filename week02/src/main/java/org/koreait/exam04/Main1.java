package org.koreait.exam04;

import org.koreait.exam02.MemberListService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
	
	MemberJoinService joinService = ctx.getBean(MemberJoinService.class);
	Member member = new Member("user01", "123456", "사용자01");
	joinService.join(member);
	
	
	MemberListService listService = ctx.getBean(MemberListService.class);
	listService.print();
	
	
	ctx.close();
	}
	
}
