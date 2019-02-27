package com.yi.domain;

import java.util.Date;

public class ReplyVO {
	private int rno;
	private String userId;
	private int bno;
	private int highReply;
	private int groupNo;
	private int groupArray;
	private int depth;
	private String replyContent;
	private String replyWriter;
	private Date replyRegdate;
	
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getHighReply() {
		return highReply;
	}
	public void setHighReply(int highReply) {
		this.highReply = highReply;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getGroupArray() {
		return groupArray;
	}
	public void setGroupArray(int groupArray) {
		this.groupArray = groupArray;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyWriter() {
		return replyWriter;
	}
	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}
	public Date getReplyRegdate() {
		return replyRegdate;
	}
	public void setReplyRegdate(Date replyRegdate) {
		this.replyRegdate = replyRegdate;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", userId=" + userId + ", bno=" + bno + ", highReply=" + highReply + ", groupNo="
				+ groupNo + ", groupArray=" + groupArray + ", depth=" + depth + ", replyContent=" + replyContent
				+ ", replyWriter=" + replyWriter + ", replyRegdate=" + replyRegdate + "]";
	}
	
	
	
}
