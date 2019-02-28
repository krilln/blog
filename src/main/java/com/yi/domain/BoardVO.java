package com.yi.domain;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int bno;
	private String userId;
	private String category;
	private String subject;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private int viewCnt;
	private int writingOpen;
	private int replyCnt;
	private List<String> files;//첨부파일
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getViewCnt() {
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	public int getWritingOpen() {
		return writingOpen;
	}
	public void setWritingOpen(int writingOpen) {
		this.writingOpen = writingOpen;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	
	public List<String> getFiles() {
		return files;
	}
	public void setFiles(List<String> files) {
		this.files = files;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", userId=" + userId + ", category=" + category + ", subject=" + subject
				+ ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate=" + regdate
				+ ", viewCnt=" + viewCnt + ", writingOpen=" + writingOpen + ", replyCnt=" + replyCnt + ", files="
				+ files + "]";
	}
	
	
	
	
}
