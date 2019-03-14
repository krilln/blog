package com.yi.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.SubjectVO;
@Repository
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.SubjectMapper";
	
	@Override
	public List<SubjectVO> subject_list() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".subject_list");
	}

}
