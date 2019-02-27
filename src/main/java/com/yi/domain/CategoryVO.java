package com.yi.domain;

public class CategoryVO {
	private String category;
	private String userId;
	private String subject;
	private boolean categoryOpen;
	private String representCategory;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public boolean isCategoryOpen() {
		return categoryOpen;
	}
	public void setCategoryOpen(boolean categoryOpen) {
		this.categoryOpen = categoryOpen;
	}
	public String getRepresentCategory() {
		return representCategory;
	}
	public void setRepresentCategory(String representCategory) {
		this.representCategory = representCategory;
	}
	
	@Override
	public String toString() {
		return "CategoryVO [category=" + category + ", userId=" + userId + ", subject=" + subject + ", categoryOpen="
				+ categoryOpen + ", representCategory=" + representCategory + "]";
	}
	
	
}
