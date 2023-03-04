package org.koreait.exam04;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect	// 공통기능을 수행하는 클래스
public class CalculatorProxy {
	@Pointcut("execution(public * org.koreait.exam04.cal..*factorial(..))")	// 적용범위
	public void publicTarget() {}
	
	@Around("publicTarget()")
	public Object calcu(ProceedingJoinPoint joinPoint) throws Throwable {
		
		long startTime = System.nanoTime();	// 공통기능
		
		Object result = joinPoint.proceed();	// 패턴에 매칭되는 메서드 호출(핵심기능 -> factorial)
		
		long endTime = System.nanoTime();	// 공통기능
		System.out.printf("걸린 시간: %d%n", endTime - startTime);
		
		return result;
	}
}
