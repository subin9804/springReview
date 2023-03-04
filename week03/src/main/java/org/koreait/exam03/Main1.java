package org.koreait.exam03;

public class Main1 {
	public static void main(String[] args) {
		Calculator cal1 = new ImplCalculator();
		int result = cal1.factorial(10);
		System.out.printf("cal1 = %d%n", result);
		
		long startTime = System.nanoTime();
		Calculator cal2 = new RecCalculator();
		int result2 = cal2.factorial(10);
		System.out.printf("cal2 = %d%n", result2);
		long endTime = System.nanoTime();
		
		System.out.printf("걸린시간 %d%n", endTime - startTime);
		
	}
}
