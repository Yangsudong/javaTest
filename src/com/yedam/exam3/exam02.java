package com.yedam.exam3;

import java.util.Arrays;
import java.util.List;

public class exam02 {
	public static void main(String[] args) {
//		int[] intAry = new int[] { 3, 2, 5, 7, 1 };
//		Arrays.sort(intAry, 0, intAry.length);
//		for(int i : intAry) {
//			System.out.println(i + " ");
//		}
		// 위의 내용과 동일하게 Stream을 활용해서 표현
		
		List<Integer> intAry = Arrays.asList(3, 2, 5, 7, 1);
		intAry.stream().sorted().forEach(s -> System.out.println(s + " "));
		
	}
}
