package com.yi.domain;

public class CategoryVO {
	private int categoryNo;
	private String category;
	private String userId;
	private String subject;
	private boolean categoryOpen;
	private boolean representCategory;
	
	
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
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public boolean isRepresentCategory() {
		return representCategory;
	}
	public void setRepresentCategory(boolean representCategory) {
		this.representCategory = representCategory;
	}
	@Override
	public String toString() {
		return "CategoryVO [categoryNo=" + categoryNo + ", category=" + category + ", userId=" + userId + ", subject="
				+ subject + ", categoryOpen=" + categoryOpen + ", representCategory=" + representCategory + "]";
	}
	
	
	
	
}
