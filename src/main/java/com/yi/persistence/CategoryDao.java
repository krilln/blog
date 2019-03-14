package com.yi.persistence;

import java.util.List;

import com.yi.domain.CategoryVO;

public interface CategoryDao {
	public List<CategoryVO> category_list(String userId);
	public void category_insert(CategoryVO vo);
	public CategoryVO category_read(String category, String userId);
	public CategoryVO category_read_byNo(int categoryNo);
}
