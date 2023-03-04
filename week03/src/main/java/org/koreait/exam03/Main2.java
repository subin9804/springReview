package org.koreait.exam03;

public class Main2 {

	public static void main(String[] args) {
		CalculatorProxy proxy = new CalculatorProxy(new ImplCalculator());
		int result1 = proxy.factorial(10);
		System.out.printf("cal1= %d%n", result1);
		
		Calculator proxy2 = new CalculatorProxy(new RecCalculator());
		int result2 = proxy2.factorial(10);
		System.out.printf("cal2= %d%n", result2);
	}
}
