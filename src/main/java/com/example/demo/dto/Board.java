package com.example.demo.dto;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

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

	public Board(int no, String title, String content, String writer, Timestamp createDate, Timestamp modifyDate, int count) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.createDate = createDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.modifyDate = modifyDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
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
