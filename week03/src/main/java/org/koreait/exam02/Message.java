package org.koreait.exam02;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {

	public void send(String message) {
		System.out.printf("전달 메세지: %s%n", message);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AfterPropertiesSet");
		// 의존성이 해결되고 난 직후에 호출되는 메서드
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
		// close하기 직전에 호출됨
		
	}
}
