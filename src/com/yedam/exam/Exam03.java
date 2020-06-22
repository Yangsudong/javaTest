package com.yedam.exam;

import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		
		System.out.print("정수 1 :");			
		int a = scn.nextInt();
		System.out.print("정수 2 :");			
		int b = scn.nextInt();
	       
		for(int i=a; i<=b; i++) {
	            sum = sum + i;
	        }
	    System.out.println(a + "와(과) " + b + "사이의 합은 " + sum);
	    
	    while(true) {
            System.out.print("정수 1 :");
            a = scn.nextInt();
            System.out.print("정수 2 :");
             b = scn.nextInt();
            if(a < b){	
            	if(b == a) {
                sum = sum + a ;
            	}
                System.out.println(a + "와(과) " + b + "사이의 합은 " + sum);
                break;
            }
	   }
	    
	}
}
