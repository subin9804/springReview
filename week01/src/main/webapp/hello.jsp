<%@page contentType="text/html; charset=utf-8"%>

<!-- _jspService 메서드의 지역 안 -->
<h1>안녕하세요!</h1>

<!-- 자바로 번역 -->
<%
	int num1 = 10;	// 지역변수
	int num2 = 20;
	int result = num1 + num2;
	
	/* String num3 = request.getParameter("num3");
	System.out.println(num3);
	
	response.sendRedirect("https://www.naver.com"); */
	
	out.write("<h1>출력!</h1>");
%>