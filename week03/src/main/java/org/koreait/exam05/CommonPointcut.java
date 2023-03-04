package org.koreait.exam05;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {

	@Pointcut("execution(* org.koreait.exam05.cal..*(..))")
	public void calculatorTarget() {}
}
