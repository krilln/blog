package com.yi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yi.domain.AdminCheckVO;
import com.yi.domain.UserVO;
import com.yi.persistence.UserDao;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public void insertUser(UserVO vo) {
		// TODO Auto-generated method stub
		dao.insertUser(vo);
	}

	@Override
	public UserVO readUser(String userId) {
		// TODO Auto-generated method stub
		return dao.readUser(userId);
	}

	@Override
	public void updateUser(UserVO vo) {
		// TODO Auto-generated method stub
		dao.updateUser(vo);
	}

	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		dao.deleteUser(userId);
	}

	@Override
	public List<UserVO> userList() {
		// TODO Auto-generated method stub
		return dao.userList();
	}

	@Override
	public UserVO read(String userId, String password) {
		// TODO Auto-generated method stub
		return dao.read(userId, password);
	}

	@Override
	public AdminCheckVO adminPw() {
		// TODO Auto-generated method stub
		return dao.adminPw();
	}

	@Override
	public boolean dulUserId(String du) {
		// TODO Auto-generated method stub
		try {
			UserVO user = dao.dulUserId(du);
			if(user == null) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
