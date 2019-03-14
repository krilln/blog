package com.yi.domain;

public class LoginDTO {
	private String userId;
	private String nickname;
	private boolean blogCheck;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	public boolean isBlogCheck() {
		return blogCheck;
	}
	public void setBlogCheck(boolean blogCheck) {
		this.blogCheck = blogCheck;
	}
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", nickname=" + nickname + ", blogCheck=" + blogCheck + "]";
	}
	
	
	
	
}
