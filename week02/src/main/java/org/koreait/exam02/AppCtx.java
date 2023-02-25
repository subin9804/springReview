package org.koreait.exam02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	@Bean
	public MemberJoinService memberJoinService() {
		return new MemberJoinService(memberDao());
	}
	
	@Bean
	public MemberListService memberListService() {
		return new MemberListService(memberDao());
	}
}
