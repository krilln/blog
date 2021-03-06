package com.yi.service;

import java.util.List;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;

public interface BoardService {
	public void regist(BoardVO vo);
	public BoardVO read(int bno);
	public void modify(BoardVO vo);
	public void modifyFile(BoardVO vo, String[] delFiles, List<String> addImages);
	public void remove(int bno);
	public List<BoardVO> listAll(String userId);
	public void setViewcnt(BoardVO vo);
	
	/*------------------------------------------*/
	
	public List<BoardVO> listCriteria(Criteria cri, String userId);
	public int totalCount(String userId);
	
	/*------------------------------------------*/
	
	public List<BoardVO> listSearch(SearchCriteria cri, String userId);
	public int searchTotalCount(SearchCriteria cri, String userId);
}
