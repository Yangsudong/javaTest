package com.yedam.exam;

public class Exam01 {
	public static void main(String[] args) {
		 int two =0;
		 int three = 0;
	        for(int i=1; i<=100; i++) {
	            if(i % 2 == 0 ) {
	            	if(i % 3 ==0){
	            	}else {
	            		two = two + i;	            		
	            	}
	            }
	            if((i % 3 == 0 ) && (i % 2 ==1 )) {
	            three = three + i;
	            }
	        }
	        System.out.println("2의배수의 합(3의 배수 제외) : " + two);
	        System.out.println("3의배수의 합(2의 배수 제외) : " + three);
	     
	}
	
}
