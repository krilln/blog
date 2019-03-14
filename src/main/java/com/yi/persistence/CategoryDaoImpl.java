package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.CategoryVO;
@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.CategoryMapper";
	
	@Override
	public List<CategoryVO> category_list(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".category_list",userId);
	}

	@Override
	public void category_insert(CategoryVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".category_insert", vo);
	}

	@Override
	public CategoryVO category_read(String category, String userId) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("category", category);
		map.put("userId", userId);
		return sqlSession.selectOne(namespace + ".category_read", map);
	}

	@Override
	public CategoryVO category_read_byNo(int categoryNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".category_read_byNo", categoryNo);
	}

}
