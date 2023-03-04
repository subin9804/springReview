package org.koreait.exam03;

public class RecCalculator implements Calculator{

	@Override
	public int factorial(int num) {
		long startTime = System.nanoTime();
				
			int total = num;
			if(num == 0) {
				return 1;			
			}
			return total * factorial(num - 1);
	}
	
}
