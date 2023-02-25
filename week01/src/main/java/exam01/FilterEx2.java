package exam01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEx2 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("공통기능 - FilterEx2");
		// 요청처리 전 공통기능
		
		chain.doFilter(request, response);	// 다음 필터가 없으면 서블릿 객체를 가져온다.
		
		// 응답처리 후 공통기능 - 서블릿이 이미 응답한 이후
		System.out.println("공통기능 - FilterEx2");
		
	}

}
