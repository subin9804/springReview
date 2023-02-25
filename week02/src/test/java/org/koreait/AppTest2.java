package org.koreait;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest2 {
	
	@Test
	public void test() {
		int num1 = 10;
		int num2 = 20;
		int result = num1 + num2;
		assertEquals(result, 30);
	}

}
