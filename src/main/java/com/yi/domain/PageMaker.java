package com.yi.domain;

public class PageMaker {
	private int totalCount; //게시물 전체갯수
	private int startPage; //현재 보이는 페이지 시작번호
	private int endPage; //현재 보이는 페이지 끝 번호
	private boolean prev; //이전 10개 존재여부
	private boolean next; //이후 10개 존재여부
	
	
	private int displayPageNum = 10; //화면에 보이는 페이지들의 갯수
	
	private Criteria cri;
	
	private void calcData() {
		//ex) 게시물이 총 151개
		//page번호를 15번 선택
		
		//현재 페이지의 끝 번호를 구한다. ex)15 / 10 => Math.ceil(1.5) -> 2* 10 -> 20
		endPage = (int) (Math.ceil(cri.getPage()/ (double) displayPageNum) * displayPageNum);
		
		//현재 페이지의 시작 번호를 구했다. ex)20 - 10 + 1 = 11
		startPage = (endPage - displayPageNum) +1;
		
		//cri.getPerPageNum() : 한 페이지에 보여질 게시물 갯수
		//전체 게시물이 151이고 현재 페이지가 15일때, 마지막 endPage는 16으로 나타나야 한다.
		//ex) Math.ceil(151/10) = 16
		int tempEndPage = (int)(Math.ceil(totalCount / (double) cri.getPerPageNum() ));  
		
		//만약, 끝 페이지가 번호(endPage)가 실제 구해진 끝 번호(tempEndPage)보다 크다면 변경해 준다.
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		//이전 페이지 번호
		prev = (startPage == 1) ? false : true;
		//이후 페이지 번호
		next = (endPage * cri.getPerPageNum() >= totalCount) ? false : true;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	
}
