package com.yi.domain;

import java.util.Date;
import java.util.List;

public class BoardVO {
	private int bno;
	private String userId;
	private int categoryNo;
	private String subject;
	private String title;
	private String content;
	private Date regdate;
	private int viewCnt;
	private int writingOpen;
	private int replyCnt;
	private List<String> files;//첨부파일
	private String category;
	
	
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
	
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", userId=" + userId + ", categoryNo=" + categoryNo + ", subject=" + subject
				+ ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", viewCnt=" + viewCnt
				+ ", writingOpen=" + writingOpen + ", replyCnt=" + replyCnt + ", files=" + files + "]";
	}
	
	
	
	
	
}
