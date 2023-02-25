package org.koreait.exam04;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberJoinService {
	
	@Autowired
	private MemberDao memberDao;
	
	
	public void join(Member member) {
		String userId = member.getUserId();
		String userPw = member.getUserPw();
		if(userId == null || userPw == null) {
			throw new RuntimeException("아이디, 비밀번호를 입력하세요.");
		}
		memberDao.join(member);
		
		//memberDao.printMembers();
	}
}
