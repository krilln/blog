package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.CategoryVO;
import com.yi.persistence.CategoryDao;
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao dao;
	
	@Override
	public List<CategoryVO> category_list(String userId) {
		// TODO Auto-generated method stub
		return dao.category_list(userId);
	}

	@Override
	public void category_insert(CategoryVO vo) {
		// TODO Auto-generated method stub
		dao.category_insert(vo);
	}

	@Override
	public CategoryVO category_read(String category, String userId) {
		// TODO Auto-generated method stub
		return dao.category_read(category, userId);
	}

	@Override
	public CategoryVO category_read_byNo(int categoryNo) {
		// TODO Auto-generated method stub
		return dao.category_read_byNo(categoryNo);
	}

}
