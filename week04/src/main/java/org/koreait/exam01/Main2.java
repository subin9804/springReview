package org.koreait.exam01;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao memberDao = ctx.getBean(MemberDao.class);
		
		// 개별조회
//		Member member = memberDao.get("user05");
//		System.out.println(member);
		
		// 전체조회
//		List<Member> members = memberDao.gets();
//		for(Member member : members) {
//			System.out.println(member);
//		}
		
		// 삭제
		boolean result = memberDao.delete("user01");
		System.out.println(result);
		
		ctx.close();
	}
}
