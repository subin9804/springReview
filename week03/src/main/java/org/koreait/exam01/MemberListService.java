package org.koreait.exam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberListService {
	
	@Autowired
	private MemberDao memberDao;

	
	public void print() {
		memberDao.printMembers();
	}
}
