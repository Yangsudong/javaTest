package com.yedam.exam;

import java.util.ArrayList;
import java.util.Scanner;

public class Exam02 {	
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null; //배열
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택> ");
			
			int selectNo = scanner.nextInt(); //scanner.nextLine();
			
			if(selectNo == 1) {
				System.out.print("학생수를 입력하세요. > ");
				studentNum = scanner.nextInt();
				scores = new int[studentNum];	
				System.out.println("학생수 [" + studentNum + "] 명이 입력 되었습니다.");
			}
			else if(selectNo == 2) {
				int i = 0;
				for(int score : scores) {       
				System.out.print("점수를 입력하세요. > ");
				score = scanner.nextInt(); 		
				scores[i++] = score;
				}
			}
			else if(selectNo == 3) {
				for(int i=0; i<scores.length; i++) {
					System.out.println("학생 [" + (i+1) + "] 점수 : " + scores[i]);
				}
			}
			else if(selectNo == 4) {
				int sum = 0;					
				int count = 0;					
				for(int score : scores) {
					sum += score;
					count++;				
				}
				double avg = (double) sum / count;
				
				//최고점수 구하는 for문
				int maxValue = Integer.MIN_VALUE;
				for(int i=0; i<scores.length; i++) {
					if(scores[i] >= maxValue ) {
						maxValue=scores[i];
					}
				}						
				System.out.println("최고점수는 : " + maxValue);				
				System.out.printf("평균은 : " + "%.1f",avg);		//소수점 한자리까지 나타냄
				System.out.println();
				
			}
			//프로그램 종료
			else if(selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
