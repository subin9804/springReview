package org.koreait.exam05;

import org.koreait.exam05.cal.Calculator;
import org.koreait.exam05.cal.ImplCalculator;
import org.koreait.exam05.cal.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.annotation.Order;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass=true)	// class 기준. proxyTargetClass를 지정하지 않으면 인터페이스 기준.
public class AppCtx {
	
	@Bean
	@Order(1)	// 첫번째로 실행
	public CalculatorProxy calculatorProxy() {
		return new CalculatorProxy();
	}

	@Bean
	@Order(2)	// 두번째로 실행
	public CachedProxy cachedProxy() {
		return new CachedProxy();
	}
	
	
	@Bean
	public Calculator implCalculator() {
		return new ImplCalculator();
	}
	
	@Bean
	public Calculator recCalculator() {
		return new RecCalculator();
	}
}
