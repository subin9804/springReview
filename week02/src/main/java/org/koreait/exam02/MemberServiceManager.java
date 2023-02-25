package org.koreait.exam02;

public class MemberServiceManager {
	public MemberDao memberDao() {
		return new CachedMemberDao();
	}
	
	public MemberJoinService getMemberJoinService() {
		MemberJoinService service = new MemberJoinService(memberDao());
		return service;
	}
	
	public MemberListService getMemberListService() {
		MemberListService service = new MemberListService(memberDao());
		return service;
	}
}
