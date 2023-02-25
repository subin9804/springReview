package org.koreait.exam04;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	private static Map<String, Member> members;
	
	static {
		if(members == null) members = new HashMap<String, Member>();
	}
	
	public void join(Member member) {
		members.put(member.getUserId(), member);
	}
	
	public void printMembers() {
		for(Map.Entry<String, Member> entry : members.entrySet()) {
			Member member = entry.getValue();
			System.out.println(member);
		}
	}
	
	public Map<String, Member> getMembers() {
		return members;
	}
}
