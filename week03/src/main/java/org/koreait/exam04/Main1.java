package org.koreait.exam04;

import org.koreait.exam04.cal.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Calculator cal1 = ctx.getBean("recCalculator", Calculator.class);
		int result1 = cal1.factorial(10);
		//System.out.println(cal1);
		System.out.printf("cal1=%d%n", result1);
		
		Calculator cal2 = ctx.getBean("implCalculator", Calculator.class);
		int result2 = cal2.factorial(10);
		System.out.printf("cal2= %d%n", result2);
		
		
		ctx.close();
	}
}
