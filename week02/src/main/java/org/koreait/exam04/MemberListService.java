package org.koreait.exam04;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberListService {
	
	@Autowired
	private MemberDao memberDao;

	
	public void print() {
		memberDao.printMembers();
	}
}
