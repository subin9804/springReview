package exam01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<form method='post' action='board'>");
		out.print("제목: <input type='text' name='subject'><br>");
		out.print("내용: <textarea name='content'></textarea><br>");
		out.print("<button type='submit'>작성하기</button>");
		out.print("</form>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8"); 	// 서버에게 글자 인코딩을 알려줌 -> 처리가능
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.printf("제목 : %s<br>", subject);
		out.printf("내용 : %s<br>", content);
		
	}

	
}
