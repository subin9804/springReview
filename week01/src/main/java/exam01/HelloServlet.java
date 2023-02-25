package exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		resp.setContentType("text/html; charset=utf-8");
		// resp.setCharacterEncoding("UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("<h1>안녕하세요!</h1>");
		*/
		
		// 주소이동
		resp.sendRedirect("https://www.naver.com"); // = resp.addHeader("Location", "https://www.naver.com")
		
	}
	
	
	
	
	
}
