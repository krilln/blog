package com.yi.service;

import java.util.List;

import com.yi.domain.BlogVO;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;

public interface BlogService {
	public void insertBlog(BlogVO vo);
	public BlogVO readBlog(String bUserId);
	public void updateBlog(BlogVO vo);
	public void deleteBlog(int blogNo);
	public List<BlogVO> blogList();
	
	public List<BlogVO> listCriteria(Criteria cri);
	public int totalCount();
	
	public List<BlogVO> listSearch(SearchCriteria cri);
	public int searchTotalCount(SearchCriteria cri);
}
