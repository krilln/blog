package com.yi.persistence;

import java.util.List;

import com.yi.domain.BoardVO;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;

public interface BoardDao {
	public void insert(BoardVO vo);
	public BoardVO read(int bno);
	public void update(BoardVO vo);
	public void delete(int bno);
	public List<BoardVO> listAll(String userId);
	public void setVcnt(BoardVO vo);
	
	
	/*-------------------------------------------*/
	
	public List<BoardVO> listPage(int bno, String userId);
	public List<BoardVO> listCriteria(Criteria cri, String userId);
	public int totalCount(String userId);
	
	/*------------------------------------------*/
	
	public List<BoardVO> listSearch(SearchCriteria cri, String userId);
	public int searchTotalCount(SearchCriteria cri, String userId);
	
	
	
	public void updateReplyCnt(int bno, int amount);
	
	
	public void addAttach(String fullname);
	public List<String> getAttach(int bno);
	public void delAttach(int bno);
	
	public void deleteAttachByFullName(int bno, String fullname);
	public void addAttachByBno(String fullname, int bno);
}
