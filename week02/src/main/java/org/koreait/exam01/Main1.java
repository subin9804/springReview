package org.koreait.exam01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx1.class);
		
		// Greet greet = ctx.getBean("greet", Greet.class);
		Greet greet = ctx.getBean(Greet.class);
		greet.hello("이이름");
		
		
		Greet greet2 = ctx.getBean("greet",Greet.class);
		System.out.println(greet == greet2);	// 싱글톤 객체
		
		ctx.close();
	}

}
