package org.koreait.models.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import org.koreait.controllers.MemberJoin;
import org.koreait.controllers.MemberSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	/**
	 * 회원 추가(update)
	 * @param params
	 * @return
	 */
	public boolean insert(MemberJoin params) {
		String sql = "INSERT INTO member (userId, userPw, userNm) VALUES(?, ?, ?);";
		int cnt = jdbcTemplate.update(sql, params.getUserId(), params.getUserPw(), params.getUserNm());
		
		return cnt > 0;
	}
	
	
	/**
	 * 회원정보 조회(queryForObject)
	 * @param userId
	 * @return
	 */
	public Member get(String userId) {
		String sql = "SELECT * FROM member WHERE userId = ?";
		try {
			Member member = jdbcTemplate.queryForObject(sql, this::memberMapper, userId);
			
			return member;
		} catch(Exception e) {
			return null;
		}
		
	}
	
	public List<Member> gets(MemberSearch memberSearch) {
		String sql = "SELECT * FROM member";
		List<LocalDate> params = new ArrayList<>();
		List<String> conds = new ArrayList<>();
		
		LocalDate sdate = memberSearch.getSdate();
		LocalDate edate = memberSearch.getEdate();
		if(sdate != null) {
			params.add(sdate);
			conds.add("regDt >= ?");
		}
		if(edate != null) {
			LocalDate edate2 = edate.plusDays(1);
			params.add(edate2);
			conds.add("regDt < ?");
		}
		
		Object[] data = params.toArray();
		
		if(conds.size() > 0) {
			sql += " WHERE ";
			sql += conds.stream().collect(Collectors.joining(" AND "));
		}
		
		List<Member> members = jdbcTemplate.query(sql, data, this::memberMapper);
		
		return members;
	}


	private Member memberMapper (ResultSet rs, int i) throws SQLException {
		Member m = new Member();
		m.setUserNo(rs.getLong("userNo"));
		m.setUserId(rs.getString("userId"));
		m.setUserPw(rs.getString("userPw"));
		m.setUserNm(rs.getString("userNm"));
		m.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
		
		return m;
	}
	
	
	
	/**
	 * 아이디로 가입여부 체크
	 * @param userId
	 * @return
	 */
	public boolean isExists(String userId) {
		String sql = "SELECT COUNT(*) FROM member WHERE userId = ?";
		int cnt = jdbcTemplate.queryForObject(sql, Integer.class, userId);
		
		return cnt > 0;
	}
	
	
}
