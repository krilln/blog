package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.BlogVO;
import com.yi.domain.Criteria;
import com.yi.domain.SearchCriteria;
@Repository
public class BlogDaoImpl implements BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.BlogMapper";
	
	@Override
	public void insertBlog(BlogVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertBlog", vo);
	}

	@Override
	public BlogVO readBlog(String bUserId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".readBlog", bUserId);
	}

	@Override
	public void updateBlog(BlogVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateBlog", vo);
	}

	@Override
	public void deleteBlog(int blogNo) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteBlog", blogNo);
	}

	@Override
	public List<BlogVO> blogList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".blogList");
	}

	@Override
	public List<BlogVO> listPage(int page) {
		// TODO Auto-generated method stub
		if(page < 0) {
			page = 1;
		}
		page = (page-1) * 10;
		return sqlSession.selectList(namespace + ".listPage", page);
	}

	@Override
	public List<BlogVO> listCriteria(Criteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listCriteria", cri);
	}

	@Override
	public int totalCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".totalCount");
	}

	@Override
	public List<BlogVO> listSearch(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".listSearch", cri);
	}

	@Override
	public int searchTotalCount(SearchCriteria cri) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".searchTotalCount", cri);
	}

}
