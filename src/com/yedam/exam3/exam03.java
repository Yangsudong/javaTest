package com.yedam.exam3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class exam03 {
	static int sum;
	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 20);
		
		
		int result = stream.filter(t -> t%2==0)
				.peek(n -> System.out.print(n + " "))
				.sum();								
			System.out.println();
			System.out.println("결과 : " + result);
	


	}

}
