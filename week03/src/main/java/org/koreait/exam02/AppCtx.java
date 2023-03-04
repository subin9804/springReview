package org.koreait.exam02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx {
	@Bean
	public Message message() {
		return new Message();
	}
	
	@Bean(initMethod="init", destroyMethod="close")
	@Scope("prototype")
	public Message2 message2() {
		return new Message2();
	}
}
