package com.yedam.exam;

public interface BoardService {
	// 추가	
	void insertBoard(Board board);	
		
	// 수정	
	void updateBoard(Board board);
		
	// 삭제	
	void deleteBoard(Integer num);
	
	// 조회
	void listBoard();
}
