package org.koreait.exam01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
@MenualBean	// 해당애노테이션은 Bean객체에서 제외됨.
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
