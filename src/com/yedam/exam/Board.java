package com.yedam.exam;

public class Board {
	String title,content;
	int num;
	Board(String title,String content,Integer num) {
		this.title = title;
		this.num = num;
		this.content = content;
	}
	public Integer getNum() {
		return num;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setNum(int num) {
		this.num = num;
	}	
	
	public String toString() {
		return "게시글번호 : " + num + "\t"+" 제목 : " + title +"\t"+ "\t 내용 : "+ content;
	}		
}
