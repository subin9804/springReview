package org.koreait.exam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx1 {
	
	@Bean
	public Greet greet() {
		Greet greet = new Greet();
		return greet;
	}
}
