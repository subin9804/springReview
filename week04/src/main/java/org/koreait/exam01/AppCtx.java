package org.koreait.exam01;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("org.koreait.exam01")
public class AppCtx {
	
	@Bean
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		String url = "jdbc:mysql://localhost:3306/springdb";
		ds.setUrl(url);
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("aA!123456");
		ds.setInitialSize(2);	// 생성할 초기 커넥션 개수를 지정
		ds.setTestWhileIdle(true);	// 커넥션이 풀에 유휴 상태로 있는 동안 검사할지 여부를 지정
		ds.setTimeBetweenEvictionRunsMillis(1000 * 10); // 커넥션 풀의 유효 커넥션을 검사할 주기를 밀리초 단위로 지정
		ds.setMinEvictableIdleTimeMillis(1000 * 30);	// 커넥션 풀에 유효 상태를 유지할 최초 시간을 밀리초 단위로 지정
		
		return ds;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
}
