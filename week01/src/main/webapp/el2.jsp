<%@page contentType="text/html; charset=utf-8"%>
<%
	pageContext.setAttribute("num", 100);
	request.setAttribute("num", 200);
	application.setAttribute("num", 300);
	//request.setAttribute("num2", 300);
%>
<%-- ${num == 200 ? '200입니다.' : '200이 아닙니다.'} --%>
${num}<br>
<!-- 범위가 좁을수록 우선순위가 높다 -->
page: ${pageScope.num}<br>
request: ${requestScope.num}<br>
application: ${applicationScope.num}