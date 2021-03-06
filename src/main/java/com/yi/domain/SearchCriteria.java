package com.yi.domain;

public class SearchCriteria extends Criteria {
	private String searchType; //t[title], c[content], w[writer]
	private String keyword;//java
	
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		 super.toString();
		return "SearchCriteria [searchType=" + searchType + ", keyword=" + keyword + "]"+super.toString();
	}
	
	
}
