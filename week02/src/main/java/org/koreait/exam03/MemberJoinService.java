package org.koreait.exam03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class MemberJoinService {

	@Autowired
	private MemberDao memberDao;
	
	private DateTimeFormatter formatter;
	
	
//	public MemberJoinService(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}
	
	
	public void join(Member member) {
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		if(userId == null || userPw == null) {
			throw new RuntimeException("아이디, 비밀번호를 입력하세요.");
		}
		
		member.setRegDt(LocalDateTime.now());
		if(formatter != null) {
			String date = formatter.format(member.getRegDt());
			System.out.printf("변경된 날짜형식: %s%n", date);
		}
		memberDao.join(member);
		
		//memberDao.printMembers();
	}
	
	/**
	@Autowired(required=false)		// bean객체가 없다면 호출하지 않고 멤버변수가 있다면 호출함
	public void setDateTimeFormatter(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}
	*/
	

	@Autowired
	public void setDateTimeFormatter(@Nullable DateTimeFormatter formatter) {	// Nullable: bean값이 없으면 멤버변수를 사용하지 않고 null 대입
		this.formatter = formatter;
	}

}
