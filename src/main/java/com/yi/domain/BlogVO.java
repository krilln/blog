package com.yi.domain;

public class BlogVO {
	private int blogNo;
	private String bUserId;
	private String blogName;
	private String introduction;
	private int skin;
	private String nickname;
	
	public int getBlogNo() {
		return blogNo;
	}
	public void setBlogNo(int blogNo) {
		this.blogNo = blogNo;
	}
	
	public String getbUserId() {
		return bUserId;
	}
	public void setbUserId(String bUserId) {
		this.bUserId = bUserId;
	}
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getSkin() {
		return skin;
	}
	public void setSkin(int skin) {
		this.skin = skin;
	}
	
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "BlogVO [blogNo=" + blogNo + ", bUserId=" + bUserId + ", blogName=" + blogName + ", introduction="
				+ introduction + ", skin=" + skin + ", nickname=" + nickname + "]";
	}
	
	
	
	
	
	
}
