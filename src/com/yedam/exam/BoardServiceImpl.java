package com.yedam.exam;

import java.util.ArrayList;
import java.util.List;


public class BoardServiceImpl implements BoardService {
	List<Board> list = new ArrayList<>();
	
	// 추가
	@Override
	public void insertBoard(Board board) {
		list.add(board);
	}
	
	// 수정
	@Override
	public void updateBoard(Board board) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNum() == (board.getNum())) {
				list.get(i).setContent(board.getContent());
				System.out.println("내용 수정 완료");
			}
			else {
				System.out.println("찾는 게시글 번호가 없습니다.");
			}
		}
	}
	
	// 삭제
	@Override
	public void deleteBoard(Integer num) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getNum().equals(num)) {
				list.remove(i);
				System.out.println("삭제 완료");
			}
			else {
				System.out.println("찾는 게시글 번호가 없습니다.");
			}
		}
	}
	
	// 조회
	@Override
	public void listBoard() {
		for(Board board : list) {
			System.out.println(board.toString());
		}
	
	}
}
