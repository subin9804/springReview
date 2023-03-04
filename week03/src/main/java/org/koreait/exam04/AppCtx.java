package org.koreait.exam04;

import org.koreait.exam04.cal.Calculator;
import org.koreait.exam04.cal.ImplCalculator;
import org.koreait.exam04.cal.RecCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {
	@Bean
	public CalculatorProxy calculatorProxy() {
		return new CalculatorProxy();
	}
	
	@Bean
	public Calculator recCalculator() {
		return new RecCalculator();
	}
	
	@Bean
	public Calculator implCalculator() {
		return new ImplCalculator();
	}
	
}
