package org.koreait.exam05;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CachedProxy {
	
	private Map<Integer, Object> cacheData = new HashMap<>();

	
	//@Pointcut("execution(* org.koreait.exam05.cal..*(..))")
	//public void cachedTarget() {}
	
	
	//@Around("cachedTarget()")
	@Around("CommonPointcut.calculatorTarget()")
	public Object cached(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Object[] args = joinPoint.getArgs();
		Integer num = (Integer)args[0];
		
		if(cacheData.containsKey(num)) {
			System.out.printf("[%d]캐시에서 가져옴%n", num);
			return cacheData.get(num);
		}
		
		Object result = joinPoint.proceed();
		cacheData.put(num, result);
		System.out.printf("[%d]캐시에 저장...%n", num);
		
		return result;
	}
}
