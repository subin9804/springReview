package exam01;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEx1 implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("공통 기능!!! - FilterEx1");
		
		chain.doFilter(request, response);	// 연결된 필터가 없으면 다음 필터를 가져와서 응답한다.
		
		System.out.println("공통 기능!!! - FilterEx1");
	}

}
