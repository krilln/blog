package com.yi.domain;

public class NeigborVO {
	private int neighborNo;
	private String userId;
	private String neighborId;
	private boolean eachOther;
	private boolean iAdd;
	private boolean addMe;
	
	public int getNeighborNo() {
		return neighborNo;
	}
	public void setNeighborNo(int neighborNo) {
		this.neighborNo = neighborNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getNeighborId() {
		return neighborId;
	}
	public void setNeighborId(String neighborId) {
		this.neighborId = neighborId;
	}
	public boolean isEachOther() {
		return eachOther;
	}
	public void setEachOther(boolean eachOther) {
		this.eachOther = eachOther;
	}
	public boolean isiAdd() {
		return iAdd;
	}
	public void setiAdd(boolean iAdd) {
		this.iAdd = iAdd;
	}
	public boolean isAddMe() {
		return addMe;
	}
	public void setAddMe(boolean addMe) {
		this.addMe = addMe;
	}
	@Override
	public String toString() {
		return "NeigborVO [neighborNo=" + neighborNo + ", userId=" + userId + ", neighborId=" + neighborId
				+ ", eachOther=" + eachOther + ", iAdd=" + iAdd + ", addMe=" + addMe + "]";
	}
	
	
	
	
}
