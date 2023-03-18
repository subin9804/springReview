<%@ page contentType="text/html; charset=utf-8"%>
<form method="post" action="join">
	<dl>
		<dt>아이디</dt>
		<dd>
			<input type="text" name="userId" value="${memberJoin.userId}"/>
		</dd>
	</dl>
	<dl>
		<dt>비밀번호</dt>
		<dd>
			<input type="password" name="userPw" value="${memberJoin.userPw}"/>
		</dd>
	</dl>
	<dl>
		<dt>회원명</dt>
		<dd>
			<input type="text" name="userNm" value="${memberJoin.userNm}"/>
		</dd>
	</dl>
	<button type="submit">가입하기</button>
</form>