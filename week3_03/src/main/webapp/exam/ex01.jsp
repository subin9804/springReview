<%@ page contentType="text/html; charset=utf-8" %>

<%
	Cookie cookie = new Cookie("key1", "value1");
	cookie.setPath(request.getContextPath());	// /week3_03 (폴더와 동일한 명칭의 path)
	cookie.setMaxAge(60 * 60 * 24 * 7);	// 7일간 cookie 유지
	response.addCookie(cookie);

%>