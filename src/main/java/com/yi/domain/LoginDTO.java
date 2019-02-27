package com.yi.domain;

public class LoginDTO {
	private String userId;
	private String nickname;
	
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
	
	@Override
	public String toString() {
		return "LoginDTO [userId=" + userId + ", nickname=" + nickname + "]";
	}
	
	
	
}
