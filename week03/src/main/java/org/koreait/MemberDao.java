package org.koreait;

import org.springframework.stereotype.Component;

@Component("memberDao2")	// 빈객체 이름: memberDao -> exam01의 MemberDao와 충돌 -> value값을 따로 정해주기
public class MemberDao {

}
