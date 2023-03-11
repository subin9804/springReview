package org.koreait.exam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	// 멤버변수로 주입
//	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 생성자 매개변수로 주입
	public MemberDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
