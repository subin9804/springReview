package org.koreait.exam02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Message2 message = ctx.getBean(Message2.class);
		
		Message2 message2 = ctx.getBean(Message2.class);
		
		System.out.println(message == message2);	// true -> 동일객체(SingleTon)
		//message.send("메세지!");
		
		
		ctx.close();
		
	}
}
