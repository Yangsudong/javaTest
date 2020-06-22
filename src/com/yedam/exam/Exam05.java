package com.yedam.exam;

import java.util.Scanner;
import java.awt.Checkbox;

public class Exam05 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);		
		BoardServiceImpl service = new BoardServiceImpl();
	
		while(true) {
			System.out.println("===============================");
			System.out.println("1.입력 2.수정 3.삭제 4.리스트 5.종료");
			System.out.println("===============================");
			System.out.print("선택 > ");
				
			int menu = scn.nextInt(); scn.nextLine();
				
			// 입력
			
			
			if(menu == 1) {						
				System.out.print("게시글번호 : ");
				int num;
				try {
					num = scn.nextInt(); scn.nextLine();							
				}
				catch(Exception e){					
					System.out.println("숫자로 입력하세요.");
					scn.nextLine();
					num = check("게시글번호 입력 : "); 
				}
				System.out.print("제목입력 : ");
				String title = scn.nextLine();
				System.out.print("내용입력 : ");
				String content = scn.nextLine();
				Board board = new Board(title, content, num);
				service.insertBoard(board); 					
			 	}
					
			// 수정
			else if(menu == 2) {
				int num;
				System.out.print("변경 게시글번호 입력 : ");
				try {
					num = scn.nextInt(); scn.nextLine();							
				}
				catch(Exception e){					
					System.out.println("숫자로 입력하세요.");
					scn.nextLine();
					num = check("게시글번호 입력 : "); 
				}
				System.out.print("수정 내용 입력 : ");
				String content = scn.nextLine();
				Board board = new Board(null, content, num);
				
				service.updateBoard(board);							
				}
				
			// 삭제
			else if(menu == 3) {
				int num;
				System.out.print("삭제할 게시글 번호 입력 : ");
				try {
					num = scn.nextInt(); scn.nextLine();							
				}
				catch(Exception e){					
					System.out.println("숫자로 입력하세요.");
					scn.nextLine();
					num = check("게시글번호 입력 : "); 
				}
				
				service.deleteBoard(num);
				}
				
			// 조회
			else if(menu == 4) {
				service.listBoard();
			}
				
			//종료
			else if(menu == 5) {
				System.out.println("종료");
				break;
				}								
			}
			System.out.println("end of prog.");		
	}
	static int check(String m) {
		Scanner scn = new Scanner(System.in);
		int num;
		while(true) {			
			try {
				System.out.print(m);
				num = scn.nextInt();
				scn.nextLine();
				break;
			}catch (Exception e) {
				System.out.println("숫자로 입력하세요.");
				scn.nextLine();
			}		
		}return num;
	}	
	
}
