package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.BlogVO;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;
import com.yi.persistence.BlogDao;
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao dao;
	
	@Override
	public void insertBlog(BlogVO vo) {
		// TODO Auto-generated method stub
		dao.insertBlog(vo);
	}

	@Override
	public BlogVO readBlog(int blogNo) {
		// TODO Auto-generated method stub
		return dao.readBlog(blogNo);
	}

	@Override
	public void updateBlog(BlogVO vo) {
		// TODO Auto-generated method stub
		dao.updateBlog(vo);
	}

	@Override
	public void deleteBlog(int blogNo) {
		// TODO Auto-generated method stub
		dao.deleteBlog(blogNo);
	}

	@Override
	public List<BlogVO> blogList() {
		// TODO Auto-generated method stub
		return dao.blogList();
	}

	@Override
	public List<BlogVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return dao.totalCount();
	}

	@Override
	public List<BlogVO> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.listSearch(cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return dao.searchTotalCount(cri);
	}

}
