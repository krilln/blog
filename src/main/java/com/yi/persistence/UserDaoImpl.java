package com.yi.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yi.domain.AdminCheckVO;
import com.yi.domain.UserVO;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "com.yi.mapper.UserMapper";
	
	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace + ".insertUser", vo);
	}

	@Override
	public UserVO readUser(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".readUser", userId);
	}

	@Override
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update(namespace + ".updateUser", vo);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		sqlSession.delete(namespace + ".deleteUser", userId);
	}

	@Override
	public List<UserVO> userList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(namespace + ".userList");
	}

	@Override
	public UserVO read(String userId, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("password", password);
		return sqlSession.selectOne(namespace + ".read", map);
	}

	@Override
	public AdminCheckVO adminPw() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".adminPw");
	}

	@Override
	public UserVO dulUserId(String UserId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace + ".dulUserId", UserId);
	}

}
