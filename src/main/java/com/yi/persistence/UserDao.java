package com.yi.persistence;

import java.util.List;

import com.yi.domain.AdminCheckVO;
import com.yi.domain.UserVO;

public interface UserDao {
	public void insertUser(UserVO vo);
	public UserVO readUser(String userId);
	public void updateUser(UserVO vo);
	public void deleteUser(String userId);
	public List<UserVO> userList();
	
	public UserVO read(String userId, String password);
	
	public AdminCheckVO adminPw();
}
