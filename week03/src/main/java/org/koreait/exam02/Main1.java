package org.koreait.exam02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Message message = ctx.getBean(Message.class);
		message.send("이이름");
		
		ctx.close();	// destroy는 삭제 직전에 호출되므로 close를 하지 않으면 destroy메서드는 호출되지 않는다.
	}
}
