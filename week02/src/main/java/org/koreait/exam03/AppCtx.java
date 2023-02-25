package org.koreait.exam03;

import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("org.koreait.exam03")
@Import(AppCtx2.class)
public class AppCtx {
	
	@Bean
	public DateTimeFormatter dateTimeFormatter() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
		return formatter;
	}
	
}
