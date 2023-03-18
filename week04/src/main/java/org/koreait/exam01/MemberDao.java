package org.koreait.exam01;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
	
	// 데이터 추가
	public boolean insert(Member member) {
		String sql = "INSERT INTO member(userId, userPw, userNm, email, mobile) " +
					 "VALUES (?, ?, ?, ?, ?)";
		int cnt = jdbcTemplate.update(sql,
									  member.getUserId(), 
									  member.getUserPw(), 
									  member.getUserNm(), 
									  member.getEmail(),
									  member.getMobile());
		return cnt > 0;
	}
	
	// 전체 데이터 조회
	public List<Member> gets() {
		String sql = "SELECT * FROM member";
		List<Member> members = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member();
				member.setUserNo(rs.getLong("userNo"));
				member.setUserId(rs.getString("userId"));
				member.setUserNm(rs.getString("userNm"));
				member.setUserPw(rs.getString("userPw"));
				member.setEmail(rs.getString("email"));
				member.setMobile(rs.getString("mobile"));
				member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
				
				return member;
			}
		});
		
		return members;
	}
	
	
	// 개별 목록 조회
	public Member get(String userId) {
		try {
			String sql = "SELECT * FROM member WHERE userId = ?";
			Member member = jdbcTemplate.queryForObject(sql, this::getMapper, userId);
			
			return member;
			
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	// 데이터 삭제
	public boolean delete(String userId) {
		String sql = "DELETE FROM member WHERE userId = ?";
		int cnt = jdbcTemplate.update(sql, userId);
		
		return cnt > 0;
	}
	
	
	// RowMapper
	private Member getMapper(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		member.setUserNo(rs.getLong("userNo"));
		member.setUserId(rs.getString("userId"));
		member.setUserNm(rs.getString("userNm"));
		member.setUserPw(rs.getString("userPw"));
		member.setEmail(rs.getString("email"));
		member.setMobile(rs.getString("mobile"));
		member.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());
		
		return member;
	}
	
	
	
	
	
	
	
	
}
