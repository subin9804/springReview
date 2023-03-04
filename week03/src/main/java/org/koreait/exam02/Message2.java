package org.koreait.exam02;

public class Message2 {
	
	public void init() {
		System.out.println("init!");
	}
	
	public void close() {
		System.out.println("close!");
	}
	
	public void send(String message) {
		System.out.printf("전달 메시지: %s%n", message);
	}
}
