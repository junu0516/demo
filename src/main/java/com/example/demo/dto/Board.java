package com.example.demo.dto;

public class Board {
	
	private int no;//글번호(pk)
	private String title; //제목
	private String content; //내용
	private String writer; //작성자
	private String createDate; //작성일
	private String modifyDate; //수정일
	private int count; //조회수
	
	public Board() {
		
	}

	public Board(int no, String title, String content, String writer, String createDate, String modifyDate, int count) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.createDate = createDate;
		this.modifyDate = modifyDate;
		this.count = count;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Board [no=" +no+", title=" + title + ", content=" + content + ", writer=" + writer + ", createDate=" + createDate
				+ ", modifyDate=" + modifyDate + ", count=" + count + "]";
	}
	
}
