package exam01;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CommonRequestWrapper extends HttpServletRequestWrapper {

	public CommonRequestWrapper(HttpServletRequest request) {
		super(request);
		
		// 요청 전 공통 기능
		try {
			request.setCharacterEncoding("UTF-8");	// ServletRequest request
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public String getParameter(String name) {
		String value =  super.getParameter(name);
		value = value.toUpperCase();
		System.out.println("기능?");
		return value;
	}
	
	

}
